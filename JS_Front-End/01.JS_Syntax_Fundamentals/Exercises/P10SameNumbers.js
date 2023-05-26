function sameNumberArr(number){

let stringNumber = String(number);
let numberArr = [Number];

numberArr = stringNumber.split('');

let isSameNumber = true;
let sumOfDigits = Number(numberArr[0]);

for (let i = 1; i < stringNumber.length; i++) {
    if(stringNumber.charAt(i-1)!==stringNumber.charAt(i)){
        isSameNumber = false;
    }
    sumOfDigits += Number(numberArr[i]);
}
console.log(isSameNumber);
console.log(sumOfDigits);
}



function sameNumberString(number){
    
    let num = Number(number);   
    let numberToStringArr = String(num);
    let sumOfDigits = 0;
    sumOfDigits = Number(numberToStringArr.charAt(0));
    let isSameNumber = true;

     for (let i = 1; i < numberToStringArr.length; i++) {
        if(numberToStringArr.charAt(i-1) !== numberToStringArr.charAt(i)){
            isSameNumber = false;
        }

        sumOfDigits += Number(numberToStringArr.charAt(i));
     } 

     console.log(isSameNumber);
     console.log(sumOfDigits);
}

// function sameNumberMap(number){
    
//     let numberAsString = '';
//         numberAsString = number.toString(); 
//         let sumOfDigits = 0;
//             sumOfDigits = numberAsString.split('').map(Number).reduce();
        
//     let isSameNumber = true;

//      for (let i = 1; i < numberToStringArr.length; i++) {
//         if(numberToStringArr.charAt(i-1) !== numberToStringArr.charAt(i)){
//             isSameNumber = false;
//         }
//      } 

//      console.log(isSameNumber);
//      console.log(sumOfDigits);
// }

sameNumberArr(2222222);
sameNumberArr(1234);
sameNumberString(2222222);
sameNumberString(1234);
sameNumberMap(2222222);