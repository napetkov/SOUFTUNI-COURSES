function printEveryNElement(array,number){

    let resultArray = [];

    for (let i = 0; i < array.length; i+=number) {
        resultArray.push(array[i]);
    }

    // array.every()

    // array.every((number,index) => {
        
    // });

    return resultArray;
}

console.log(printEveryNElement(
    ['1', 
    '2',
    '3', 
    '4', 
    '5'], 
    6
));