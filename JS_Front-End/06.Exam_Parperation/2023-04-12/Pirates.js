function pirates(input){
    let citiesMap = {};

    const commandParser = {
        Plunder: townPlunder,
        Prosper: townProsper,
    }



    while(input[0] !== 'Sail'){
        const cityInfoLine = input.shift();
        [ city, population, gold] = cityInfoLine.split('||');
        

        if(citiesMap.hasOwnProperty(city)){
            citiesMap[city].population = citiesMap[city].population + Number(population);
            citiesMap[city].gold = citiesMap[city].gold + Number(gold);
        }else {
        citiesMap[city] = { 
            population: Number(population), 
            gold: Number(gold),
        };
    }
    }

    input.shift();

    while(input[0] !== 'End'){
        const commandLine = input.shift();
        [ command, town, parameter, gold] = commandLine.split('=>');

        commandParser[command](town, parameter, gold);

    }

    if(Object.values(citiesMap).length === 0){
        console.log("Ahoy, Captain! All targets have been plundered and destroyed!");
    }else {
        console.log(`Ahoy, Captain! There are ${Object.values(citiesMap).length} wealthy settlements to go to:`)

        for (const town in citiesMap) {
        console.log(`${town} -> Population: ${citiesMap[town].population} citizens, Gold: ${citiesMap[town].gold} kg`)


        }
    }


    function townPlunder(town, people, gold){
       citiesMap[town].population = citiesMap[town].population - Number(people);
       citiesMap[town].gold = citiesMap[town].gold - Number(gold);

       console.log(`${town} plundered! ${gold} gold stolen, ${people} citizens killed.`);

       if(citiesMap[town].population <= 0 || citiesMap[town].gold <= 0){
        delete citiesMap[town];
        console.log(`${town} has been wiped off the map!`)
       }
    }

    function townProsper(town, gold){
        if(gold > 0){
            citiesMap[town].gold += Number(gold);
            console.log(`${gold} gold added to the city treasury. ${town} now has ${citiesMap[town].gold} gold.`)
        }else{
            console.log("Gold added cannot be a negative number!");
        }
    }

}

pirates(["Tortuga||345000||1250",
"Santo Domingo||240000||630",
"Havana||410000||1100",
"Sail",
"Plunder=>Tortuga=>75000=>380",
"Prosper=>Santo Domingo=>180",
"End"])
