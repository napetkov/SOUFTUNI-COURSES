package ObjectsAndClasses.MoreExercises.p02RawData;

public class Cargo {
        String model;
        int cargoWeight;
        String cargoType;

        public Cargo(String model, int cargoWeight, String cargoType) {
            this.model = model;
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

