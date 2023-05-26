function roadRadar(speed, area) {
  let speedLimit;

  switch (area) {
    case "motorway":
      speedLimit = 130;
      break;
    case "interstate":
      speedLimit = 90;
      break;
    case "city":
      speedLimit = 50;
      break;
    case "residential":
      speedLimit = 20;
      break;
  }

  let speedOverTheLimit = speed - speedLimit;
  let speedStatus;

  if (speedOverTheLimit <= 0) {
    console.log(`Driving ${speed} km/h in a ${speedLimit} zone`);
  } else {
    if (speedOverTheLimit <= 20) {
      speedStatus = "speeding";
    } else if (speedOverTheLimit <= 40) {
      speedStatus = "excessive speeding";
    } else {
      speedStatus = "reckless driving";
    }

    console.log(
      `The speed is ${speedOverTheLimit} km/h faster than the allowed speed of ${speedLimit} - ${speedStatus}`
    );
  }
}

// roadRadar(40, 'city');
roadRadar(21, 'residential');
// roadRadar(120, 'interstate');
