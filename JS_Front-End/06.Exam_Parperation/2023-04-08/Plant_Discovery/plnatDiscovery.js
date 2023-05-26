function plantDiscovery(input){

    const numberOfPlants = Number(input.shift());
    const commandParser = {
        Rate: addRate,
        Update: updateRarity,
        Reset: resetRating, 

    }
    let plants = {};

    for (let index = 0; index < numberOfPlants; index++) {
       const inputLine = input.shift();
       const name = inputLine.split('<->')[0];
       const rarity = Number(inputLine.split('<->')[1]);
       const rating = [];
        plants[name] = {rarity, rating};
    }   
    

    while(input[0] !== 'Exhibition'){
        const commandLine = input.shift();
        const command = commandLine.split(': ')[0];
        const commandInput = commandLine.split(': ')[1];

        commandParser[command](commandInput);

    }

    function addRate(commandInput){
        const plantName = commandInput.split(' - ')[0];
       if(plants.hasOwnProperty(plantName)){
        const currentRating = Number(commandInput.split(' - ')[1]);
        const currentPlant = plants[plantName];
        currentPlant.rating.push(currentRating)
    }else{
        console.log('error');
    }
    }
    function updateRarity(commandInput){
        const [plantName, newRarity] = commandInput.split(' - ');
        if(plants.hasOwnProperty(plantName)){
        const currentPlant = plants[plantName];
        currentPlant.rarity = newRarity;
    }else{
        console.log('error');
    }
}
    function resetRating(commandInput){
        if(plants.hasOwnProperty(commandInput)){
        const currentPlant = plants[commandInput];
        currentPlant.rating = [];
    }else{
        console.log('error');
    }
    }
    console.log('Plants for the exhibition:');
    for (const plant in plants) {
        
        let sumRating = plants[plant].rating.reduce((a,b) =>{
            return a+b;
        },0);
        let averageRating = sumRating/plants[plant].rating.length;
        if(sumRating === 0){
            averageRating = 0;
        }

        console.log(`- ${plant}; Rarity: ${plants[plant].rarity}; Rating: ${averageRating.toFixed(2)}`)
    }

}

plantDiscovery(["3",
"Arnoldii<->4",
"Woodii<->7",
"Welwitschia<->2",
"Rate: Wooodii - 10",
"Rate: Welwitschia - 7",
"Rate: Arnoldii - 3",
"Rate: Woodii - 5",
"Update: Woodii - 5",
"Reset: Arnoldii",
"Exhibition"]);

// plantDiscovery(["2",
// "Candelabra<->10",
// "Oahu<->10",
// "Rate: Oahu - 7",
// "Rate: Candelabra - 6",
// "Exhibition"])
