function makeADictionary(input){
    let texts = input
    .map((text) => JSON.parse(text))
    .reduce((data,currentObject) => {
        let key = Object.keys(currentObject);
        let value = Object.values(currentObject)[0];
        data[key] = value;
        return data;
    },{});

    Object.entries(texts)
    .sort((textA,textB) => textA[0].localeCompare(textB[0]))
    .forEach(([term,definition]) => console.log(`Term: ${term} => Definition: ${definition}`));
}
makeADictionary([
    '{"Coffee":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]
    )