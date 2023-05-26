function validityChecker(x1,y1,x2,y2){


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

validityChecker(3, 0, 0, 4);
validityChecker(2, 1, 1, 1);
