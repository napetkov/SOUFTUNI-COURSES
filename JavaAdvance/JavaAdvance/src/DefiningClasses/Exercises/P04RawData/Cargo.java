package DefiningClasses.Exercises.P04RawData;

public class Cargo {
        private String cargoWeight;
        private String cargoType;

        public Cargo(String cargoWeight, String cargoType) {
                this.cargoWeight = cargoWeight;
                this.cargoType = cargoType;
        }

        public String getCargoWeight() {
                return cargoWeight;
        }

        public void setCargoWeight(String cargoWeight) {
                this.cargoWeight = cargoWeight;
        }

        public String getCargoType() {
                return cargoType;
        }

        public void setCargoType(String cargoType) {
                this.cargoType = cargoType;
        }
}
