function needForSpeed(input){
    const numberOfCars = Number(input.shift());

    const cars = {};
    const commandParser = {
        Drive: driveCar,
        Refuel: refuelCar,
        Revert: revert,
    }

    for (let i = 0; i < numberOfCars; i++) {
        const carInfo = input.shift();
        const [ car, distance, fuel] = carInfo.split('|');
        cars[car] = { 
            distance: Number(distance), 
            fuel: Number(fuel)
        };
    }


    while(input[0] !== 'Stop'){
        const commandLine = input.shift();
        const [ command, car, parameter1, parameter2] = commandLine.split(' : ');

        commandParser[command](car, Number(parameter1), Number(parameter2));

    }

    for (const car in cars) {
       console.log(`${car} -> Mileage: ${cars[car].distance} kms, Fuel in the tank: ${cars[car].fuel} lt.`)


    }

    function driveCar(car, distance, fuel){
        if(cars[car].fuel < fuel){
            console.log('Not enough fuel to make that ride');
        }else {
            console.log(`${car} driven for ${distance} kilometers. ${fuel} liters of fuel consumed.`);
            cars[car].fuel -= fuel;
            cars[car].distance += distance;
        }

        if(cars[car].distance >= 100000){
            console.log(`Time to sell the ${car}!`);
            delete cars[car];
        }
    }

    function refuelCar( car, fuel){
        if(cars[car].fuel + fuel >= 75){
            fuel = 75 - cars[car].fuel;
            cars[car].fuel = 75;
        }else{
            cars[car].fuel += fuel;
        }
        console.log(`${car} refueled with ${fuel} liters`)

    }

    function revert( car, kilometers){
        cars[car].distance -= kilometers;
        if(cars[car].distance < 10000){
            cars[car].distance = 10000;
        }else{
            console.log(`${car} mileage decreased by ${kilometers} kilometers`)
        }
    }

}
needForSpeed([
    '3',
    'Audi A6|38000|62',
    'Mercedes CLS|11000|35',
    'Volkswagen Passat CC|45678|5',
    'Drive : Audi A6 : 543 : 47',
    'Drive : Mercedes CLS : 94 : 11',
    'Drive : Volkswagen Passat CC : 69 : 8',
    'Refuel : Audi A6 : 50',
    'Revert : Mercedes CLS : 500',
    'Revert : Audi A6 : 30000',
    'Stop'
  ]
  )