function cities(city){

const tuples = Object.entries(city).forEach(([key,value]) => console.log(`${key} -> ${value}`))

}

cities({
    name: "Sofia",
    area: 492,
    population: 1238438,
    country: "Bulgaria",
    postCode: "1000"
}
);