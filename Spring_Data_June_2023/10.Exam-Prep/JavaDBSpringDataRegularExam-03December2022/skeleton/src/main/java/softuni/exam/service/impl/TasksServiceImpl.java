package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskDto;
import softuni.exam.models.dto.TaskImportDto;
import softuni.exam.models.dto.TasksWrapperDto;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.models.Constant.*;
// TODO: Implement all methods

@Service
public class TasksServiceImpl implements TasksService {
    private static String TASKS_FILE_PATH =
            "src/main/resources/files/xml/tasks.xml";
    private final TasksRepository tasksRepository;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final CarsRepository carsRepository;

    private final XmlParser xmlParser;
    private final ValidationUtils validationUtils;
    private final ModelMapper mapper;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository,
                            MechanicsRepository mechanicsRepository,
                            PartsRepository partsRepository, CarsRepository carsRepository,
                            XmlParser xmlParser,
                            ValidationUtils validationUtils,
                            ModelMapper mapper) {
        this.tasksRepository = tasksRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();

        List<TaskImportDto> tasks = this.xmlParser
                .fromFile(Path.of(TASKS_FILE_PATH).toFile(), TasksWrapperDto.class)
                .getTasks();

        for (TaskImportDto task : tasks) {
            stringBuilder.append(System.lineSeparator());

            Optional<Mechanic> mechanic = this.mechanicsRepository.findFirstByFirstName(task.getMechanic().getFirstName());

            Optional<Car> car = this.carsRepository.findById(task.getCar().getId());
            Optional<Part> part = this.partsRepository.findById(task.getPart().getId());

            if (mechanic.isEmpty() ||
                    car.isEmpty() ||
                    part.isEmpty() ||
                    !validationUtils.isValid(task)) {
                stringBuilder.append(String.format(INVALID_FORMAT, TASK));

                continue;
            }

            Task taskToSave = this.mapper.map(task, Task.class);
            taskToSave.setCar(car.get());
            taskToSave.setMechanic(mechanic.get());
            taskToSave.setPart(part.get());

            this.tasksRepository.save(taskToSave);

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT, TASK, task.getPrice().setScale(2), "").trim());

        }


        return stringBuilder.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder stringBuilder = new StringBuilder();

        return this.tasksRepository.findAllByCarCarTypeOrderByPriceDesc(CarType.coupe)
                .stream()
                .map(task -> mapper.map(task, TaskDto.class))
                .map(TaskDto::toString)
                .collect(Collectors.joining("\n"))
                .trim();

    }
}
