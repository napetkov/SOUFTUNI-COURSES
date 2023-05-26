function piccolo(input) {
  let cars = new Set();

  for (const line of input) {
    let [command, carNum] = line.split(", ");

    if (command === "IN") {
      cars.add(carNum);
    } else if (command === "OUT") {
      cars.delete(carNum);
    }
  }
  if (cars.size === 0) {
    console.log("Parking Lot is Empty");
  } else {
    [...cars.keys()]
      .sort((carA, carB) => carA.localeCompare(carB))
      .forEach((car) => console.log(car));
  }
}

piccolo([
  "IN, CA2844AA",
  "IN, CA1234TA",
  "OUT, CA2844AA",
  "IN, CA9999TT",
  "IN, CA2866HI",
  "OUT, CA1234TA",
  "IN, CA2844AA",
  "OUT, CA2866HI",
  "IN, CA9876HH",
  "IN, CA2822UU",
]);

piccolo(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'OUT, CA1234TA']
);
