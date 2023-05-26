function convertToObject(jasonString){
    let data = JSON.parse(jasonString);

Object.entries(data).forEach(([key, value]) => console.log(`${key}: ${value}`));

}

convertToObject('{"name": "George", "age": 40, "town": "Sofia"}')