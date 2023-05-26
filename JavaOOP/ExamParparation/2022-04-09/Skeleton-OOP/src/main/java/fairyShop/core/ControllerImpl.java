package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;


    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;

        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);

        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        Instrument instrument = new InstrumentImpl(power);

        if (helperRepository.getModels().contains(helper)) {
            helper.addInstrument(instrument);
        } else {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }

        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present present = presentRepository.findByName(presentName);
        ShopImpl shop = new ShopImpl();
        String done;
        boolean readyHelper = false;

        for (Helper helper : helperRepository.getModels()) {
            if (helper.getEnergy() > 50) {
                shop.craft(present, helper);
                readyHelper = true;
            }
        }

        if (!readyHelper) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        if (present.isDone()) {
            done = "done";
        } else {
            done = "not done";
        }

        long brokenInstruments = 0;
        for (Helper helper : helperRepository.getModels()) {
            brokenInstruments += helper.getInstruments().stream().filter(Instrument::isBroken).count();
        }


        String result = String.format(PRESENT_DONE, presentName, done)
                + String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstruments);

        return result;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        long countCraftedPresents = presentRepository
                .getModels()
                .stream()
                .filter(Present::isDone)
                .count();



        sb.append(String.format("%d presents are done!", countCraftedPresents)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : helperRepository.getModels()) {
            long notBrokenInstruments = helper.getInstruments().size()
                    - helper.getInstruments().stream().filter(Instrument::isBroken).count();

            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %d",helper.getEnergy())).append(System.lineSeparator());
            sb.append(String.format("Instruments: %d not broken left",notBrokenInstruments)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
