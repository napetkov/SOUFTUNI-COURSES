function solve(radius){

let type = typeof(radius);

if(type === 'number'){
    let circleArea =radius**2*Math.PI; 

    console.log(circleArea.toFixed(2));
}else{
    console.log(`We can not calculate the circle area, because we receive a ${typeof(radius)}.`)
}

}

solve('a');