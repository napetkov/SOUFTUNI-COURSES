function validityChecker(number){
    let x1 = number[0];
    let y1 = number[1];
    let x2 = number[2];
    let y2 = number[3];

    function validityBetweenTowPoint(x1,y1,x2,y2){

        let distance = Math.sqrt((x2-x1)**2 + (y2-y1)**2);

        if(Number.isInteger(distance)){
            return `{${x1}, ${y1}} to {${x2}, ${y2}} is valid`
        }else{
            return `{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`
        }
    }
console.log(validityBetweenTowPoint(x1,y1,0,0));
console.log(validityBetweenTowPoint(x2,y2,0,0));
console.log(validityBetweenTowPoint(x1,y1,x2,y2));

}

validityChecker([0, 0, 0, 0]);
validityChecker([2, 1, 1, 1]);