function flightSchedule(input) {
  let currentStatus = input[2][0];
  let changedStatusFlights = input[1];

  let flights = input[0].reduce((data, currentValue) => {
    let currentValueArr = currentValue.split(' ');
    let flightNumber = currentValueArr[0];
    let destination = currentValueArr[1];
    
    if(currentValueArr.length === 3){
        destination = currentValueArr[1] + ' ' + currentValueArr[2];
    }
    
    let flightObj = {
      Destination: destination,
      Status: "Ready to fly",
    };
    data[flightNumber] = flightObj;
    return data;
  }, {});

  changedStatusFlights.forEach((flightInfo) => {
    let [flightNumber, currentStatus] = flightInfo.split(" ");

    let currentFlight = flights[flightNumber];

    if(currentFlight !== undefined){
    currentFlight.Status = currentStatus;
    }
  });
 
       Object.values(flights)
        .filter((flight) => flight.Status === currentStatus)
        .forEach((f) => console.log(f));
}

flightSchedule([['WN269 Delaware',
'FL2269 Oregon',
 'WN498 Las Vegas',
 'WN3145 Ohio',
 'WN612 Alabama',
 'WN4010 New York',
 'WN1173 California',
 'DL2120 Texas',
 'KL5744 Illinois',
 'WN678 Pennsylvania'],
 ['DL2120 Cancelled',
 'WN612 Cancelled',
 'WN1173 Cancelled',
 'SK330 Cancelled'],
 ['Ready to fly']
]
);
