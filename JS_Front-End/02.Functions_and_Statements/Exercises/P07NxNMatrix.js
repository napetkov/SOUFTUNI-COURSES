function matrix(number){

    // let printRow = (number) => (number.toString()+' ').repeat(number);

    // for( i = 0; i < number; i++){
    //     console.log(printRow(number));
    // }

console.log(new Array(number).fill(new Array(number).fill(number).join(' ')).join('\n'));

}

matrix(7);