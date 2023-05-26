function memoryGame(input){
        let sequence = input.shift().split(' ');
        let movesCounter = 1;
        let winnersFlag = false;

        while(input[0] !== 'end'){
            const indexes = input.shift().split(' ');
            const index1 = Number(indexes[0]);
            const index2 = Number(indexes[1]);

            if(indexValidation(sequence,movesCounter,index1,index2)){
                if(sequence[index1] === sequence[index2]){
                    console.log(`Congrats! You have found matching elements - ${sequence[index1]}!`)
                    if(index1 > index2){
                        sequence.splice(index1,1);
                        sequence.splice(index2,1);
                    }else {
                        sequence.splice(index2,1);
                        sequence.splice(index1,1);
                    }
                }else{
                    console.log('Try again!');
                }
            }

            if(sequence.length < 1){
                winnersFlag = true;
                break;
            }
            movesCounter++;
        }

        if(winnersFlag){
            console.log(`You have won in ${movesCounter} turns!`);
        }else {
            console.log('Sorry you lose :(');
            console.log(sequence.join(' '))
        }

function indexValidation(sequence, movesCounter,index1, index2){
    if(index1 === index2 || index1 < 0 || index1 > sequence.length-1 || index2 < 0 || index2 > sequence.length-1){
    for (let i = 0; i < 2; i++) {
        sequence.splice(Math.floor(sequence.length/2),0,`-${movesCounter}a`);
    }
    console.log('Invalid input! Adding additional elements to the board');
        return false;
    }
    return true;
}


}

memoryGame(  [
    "1 1", 
    "1 1",
    "1 0",
    "end"
    ]
      
)