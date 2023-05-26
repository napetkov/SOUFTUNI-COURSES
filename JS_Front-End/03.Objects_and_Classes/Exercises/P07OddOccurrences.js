function oldOccurrence(input) {
    let elements = input.toLowerCase().split(" ");

  let reducedElements = elements.reduce((data, currentValue) => {
    let lengthOfRepeatedElements = elements.filter((el) => el === currentValue).length;
    data[currentValue] = lengthOfRepeatedElements;
    return data;
  }, {});

  let result = Object.entries(reducedElements)
  .filter(([_key,value]) => value % 2 !== 0)
  .map((element) => element[0])
  .join(' ');
  


  console.log(result);
}

oldOccurrence("Java C# Php PHP Java PhP 3 C# 3 1 5 C#");
oldOccurrence("Cake IS SWEET is Soft CAKE sweet Food");
