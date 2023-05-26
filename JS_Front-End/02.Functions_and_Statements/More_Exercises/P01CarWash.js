function carWash(commands) {
  let cleanedCar = 0;

  const soap = (num) => num + 10;
  const water = (num) => num * 1.2;
  const vacuumCleaner = (num) => num * 1.25;
  const mud = (num) => num * 0.9;

  for (let i = 0; i < commands.length; i++) {
    switch (commands[i]) {
      case "soap":
        cleanedCar = soap(cleanedCar);
        break;
      case "water":
        cleanedCar = water(cleanedCar);
        break;
      case "vacuum cleaner":
        cleanedCar = vacuumCleaner(cleanedCar);
        break;
      case "mud":
        cleanedCar = mud(cleanedCar);
        break;
    }
  }

  console.log(`The car is ${cleanedCar.toFixed(2)}% clean.`);
}

carWash(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
carWash(["soap", "water", "mud", "mud", "water", "mud", "vacuum cleaner"]);
