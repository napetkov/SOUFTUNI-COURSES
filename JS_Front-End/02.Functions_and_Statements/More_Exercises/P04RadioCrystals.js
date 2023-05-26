function radioCrystal([targetThickness, ...chunksThickness]) {
  
    const cut = (targetThickness, currentThickness, countOperations) => {
    while (targetThickness <= currentThickness / 4) {
        currentThickness = currentThickness / 4;
        countOperations++;
      
        if (currentThickness / 4 < targetThickness) {
        console.log(`Cut x${countOperations}`);
        currentThickness = transportingAndWashing(currentThickness);
        break;
      }
    }

    return currentThickness;
  };

  const lap = (targetThickness, currentThickness, countOperations) => {
    while (targetThickness <= currentThickness - currentThickness*0.20) {
        currentThickness -= currentThickness * 0.2;
        countOperations++;
      
        if (currentThickness - currentThickness * 0.2 < targetThickness) {
        console.log(`Lap x${countOperations}`);
        currentThickness = transportingAndWashing(currentThickness);
        break;
      }
    }

    return currentThickness;
  };

  const grind = (targetThickness, currentThickness, countOperations) => {
    while (targetThickness <= currentThickness - 20) {
        currentThickness -= 20;
        countOperations++;
     
        if (currentThickness - 20 < targetThickness) {
        console.log(`Grind x${countOperations}`);
        currentThickness = transportingAndWashing(currentThickness);
        break;
      }
    }

    return currentThickness;
  };

  const etch = (targetThickness, currentThickness, countOperations) => {
    while (targetThickness <= currentThickness) {
        currentThickness -= 2;
        countOperations++;
     
        if (currentThickness <= targetThickness) {
        console.log(`Etch x${countOperations}`);
        currentThickness = transportingAndWashing(currentThickness);
        break;
      }
    }

    return currentThickness;
  };
  const xRay = (targetThickness, currentThickness) => {

    if (currentThickness + 1 === targetThickness) {
      currentThickness++;
      console.log(`X-ray x1`);
    }

    return currentThickness;
  };

  const transportingAndWashing = (num) => {
    num = Math.floor(num);
    console.log("Transporting and washing");
    return num;
  };

  let currentThickness = 0;

  for (i = 0; i < chunksThickness.length; i++) {
    currentThickness = chunksThickness[i];

    if(currentThickness === 0 ){
        break;
    }

    let countOperations = 0;

    console.log(`Processing chunk ${currentThickness} microns`);

    currentThickness = cut(targetThickness, currentThickness, countOperations);

    if (currentThickness === targetThickness) {
      console.log(`Finished crystal ${currentThickness} microns`);
      continue;
    }

    currentThickness = lap(targetThickness, currentThickness, countOperations);

    if (currentThickness === targetThickness) {
      console.log(`Finished crystal ${currentThickness} microns`);
      continue;
    }

    currentThickness = grind(
      targetThickness,
      currentThickness,
      countOperations
    );

    if (currentThickness === targetThickness) {
      console.log(`Finished crystal ${currentThickness} microns`);
      continue;
    }

    currentThickness = etch(targetThickness, currentThickness, countOperations);

    if (currentThickness === targetThickness) {
      console.log(`Finished crystal ${currentThickness} microns`);
      continue;
    }
    currentThickness = xRay(targetThickness, currentThickness);

    if (currentThickness === targetThickness) {
      console.log(`Finished crystal ${currentThickness} microns`);
      continue;
    }
  }
}
radioCrystal([100, 99]);
// radioCrystal([1000, 4000, 8100]);
