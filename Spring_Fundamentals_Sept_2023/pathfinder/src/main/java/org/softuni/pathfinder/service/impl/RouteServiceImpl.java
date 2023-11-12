package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.exceptions.RouteNotFoundException;
import org.softuni.pathfinder.models.Route;
import org.softuni.pathfinder.models.dto.binding.AddRouteBidingModel;
import org.softuni.pathfinder.models.dto.binding.UploadPictureRouteBindingModel;
import org.softuni.pathfinder.models.dto.view.RouteCategoryViewModel;
import org.softuni.pathfinder.models.dto.view.RouteDetailViewModel;
import org.softuni.pathfinder.models.dto.view.RouteViewModel;
import org.softuni.pathfinder.models.enums.CategoryNames;
import org.softuni.pathfinder.reposritory.CategoryRepository;
import org.softuni.pathfinder.reposritory.RouteRepository;
import org.softuni.pathfinder.service.RouteService;
import org.softuni.pathfinder.service.UserService;
import org.softuni.pathfinder.service.session.LoggedUser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteServiceImpl implements RouteService {

    private static final String BASE_GPX_COORDINATE_PATH = ".\\src\\main\\resources\\coordinates\\";
    private static final String BASE_IMAGES_PATH = ".\\src\\main\\resources\\images\\";
    private final RouteRepository routeRepository;
    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryRepository categoryRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public List<RouteViewModel> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(route -> modelMapper.map(route, RouteViewModel.class))
                .toList();
    }

    @Override
    public RouteDetailViewModel getDetails(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new RouteNotFoundException("Route with id: " + id + " was not found!"));

        return modelMapper.map(route, RouteDetailViewModel.class);
    }


    @Override
    public void add(AddRouteBidingModel addRouteBidingModel) {
        Route route = modelMapper.map(addRouteBidingModel, Route.class);

        String filePath = getFilePath(route.getName());
        boolean isUploaded = uploadGpxCoordinates(addRouteBidingModel.getGpxCoordinates(), filePath);

        if(isUploaded){
            route.setGpxCoordinates(filePath);
        }

        routeRepository.save(route);
    }

    @Override
    public void uploadPicture(UploadPictureRouteBindingModel uploadPictureRouteBindingModel) {
        MultipartFile pictureFile = uploadPictureRouteBindingModel.getPicture();

        String picturePath = getPicturePath(pictureFile);

        try {

            File file = new File(BASE_IMAGES_PATH + picturePath);
            file.getParentFile().mkdirs();
            file.createNewFile();

            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(pictureFile.getBytes());

            Optional<Route> optionalRoute = routeRepository.findById(uploadPictureRouteBindingModel.getId());

            if(optionalRoute.isPresent()){
                Route route = optionalRoute.get();
                route.setImageUrl(picturePath);
                routeRepository.save(route);
            }
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public List<RouteCategoryViewModel> getAllByCategory(CategoryNames categoryName) {
        return routeRepository.findAllByCategories_Name(categoryName)
                .stream().map(route -> modelMapper.map(route, RouteCategoryViewModel.class))
                .toList();
    }

    private String getPicturePath(MultipartFile pictureFile) {
        String[] splitPictureName = pictureFile.getOriginalFilename().split("\\.");
        String ext = splitPictureName[splitPictureName.length - 1];

        String pathPattern = "%s\\%s."+ext;
        return String.format(pathPattern,
                loggedUser.getUsername(),
                UUID.randomUUID());
    }

    private String getFilePath(String routeName) {
        String pathPattern = "%s\\%s_%s.xml";

        return String.format(pathPattern,
                loggedUser.getUsername(),
                transformRouteName(routeName),
                UUID.randomUUID());
    }

    private String transformRouteName(String routeName) {
        return routeName.toLowerCase()
                .replaceAll("\\s+", "_");
    }

    private boolean uploadGpxCoordinates(MultipartFile file, String filePath) {
        try {
            File newFile = new File(BASE_GPX_COORDINATE_PATH + filePath);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();

            OutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(file.getBytes());
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
