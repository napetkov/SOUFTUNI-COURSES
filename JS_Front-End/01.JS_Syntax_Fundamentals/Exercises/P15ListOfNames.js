function listOfNames(names){

return [...names].sort((first, second) => first.localeCompare(second))
    .map((currentName, index) => `${index + 1}.${currentName}`)
    .join('\n');

}

console.log(listOfNames(["John", "Bob", "Christina", "Ema"]));