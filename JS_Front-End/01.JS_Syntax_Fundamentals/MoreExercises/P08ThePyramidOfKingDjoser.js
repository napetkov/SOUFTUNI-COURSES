function pyramid(base, increase){
let stones = 0;
let marble = 0;
let lapisLazuli = 0;
let gold = 0;
let steps = 0;



while(base > 0){
    steps ++;

    if(base <= 2){
        gold = base ** 2;
        break;
    }

    let bulkSide = base - 2;
    let bulk = bulkSide ** 2;// area
    let outerLayer = base * 4 - 4; // base perimeter without 4 angles

    stones += bulk;

    if(steps % 5 === 0){
        lapisLazuli += outerLayer;
    }else{
        marble += outerLayer;
    }

    base -= 2;
}
stones = Math.ceil(stones * increase);
marble = Math.ceil(marble * increase);
lapisLazuli = Math.ceil(lapisLazuli * increase);
gold = Math.ceil(gold * increase);
let finalHeight = Math.floor(steps * increase);

console.log(`Stone required: ${stones}`);
console.log(`Marble required: ${marble}`);
console.log(`Lapis Lazuli required: ${lapisLazuli}`);
console.log(`Gold required: ${gold}`);
console.log(`Final pyramid height: ${finalHeight}`);

}

pyramid(12,1);