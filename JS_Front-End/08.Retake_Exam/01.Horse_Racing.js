function horseRacing(input){
let horsePosition = input.shift().split('|');

const commandParser = {
    Retake: retakeHorses,
    Trouble: horseTrouble,
    Rage: horseRage,
    Miracle: horseMiracle,
}


while(input[0] !== 'Finish'){
const commandLine = input.shift().split(' ');
const command = commandLine.shift();

commandParser[command](horsePosition, ...commandLine);
}

console.log(horsePosition.join('->'));
console.log(`The winner is: ${horsePosition[horsePosition.length-1]}`)

function horseMiracle(horsePosition){
    const lastHorse = horsePosition[0];

    for (let i = 0; i < horsePosition.length -1 ; i++) {
        horsePosition[i] = horsePosition[i+1];        
    }
    horsePosition[horsePosition.length-1] = lastHorse;
    console.log(`What a miracle - ${lastHorse} becomes first.`)
}

function horseRage(horsePosition,horse){
    const indexOfHorse = horsePosition.indexOf(horse);
    const currentHorse = horsePosition[indexOfHorse];

    if(indexOfHorse < horsePosition.length - 2){
        const previousHorse = horsePosition[indexOfHorse + 1];
        horsePosition[indexOfHorse] = previousHorse;
        horsePosition[indexOfHorse + 1] = horsePosition[indexOfHorse + 2];
        horsePosition[indexOfHorse + 2] = currentHorse;
    }else if(indexOfHorse < horsePosition.length - 1){
        horsePosition[indexOfHorse] = horsePosition[indexOfHorse + 1];
        horsePosition[indexOfHorse + 1] = currentHorse;         
    }
    console.log(`${horse} rages 2 positions ahead.`)
}

function horseTrouble(horsePosition, horse){
    const indexOfHorse = horsePosition.indexOf(horse);
    if(indexOfHorse > 0){
        horsePosition[indexOfHorse] = horsePosition[indexOfHorse - 1];
        horsePosition[indexOfHorse - 1] = horse;
        console.log(`Trouble for ${horse} - drops one position.`)


    }


}

function retakeHorses(horsePosition, overtakingHorse, overtakenHorse){
    const indexOfOvertakingHorse = horsePosition.indexOf(overtakingHorse);
    const indexOfOvertakenHorse = horsePosition.indexOf(overtakenHorse);
    if( indexOfOvertakingHorse < indexOfOvertakenHorse){
        const secondHorse = horsePosition[indexOfOvertakingHorse];
        const firstHorse = horsePosition[indexOfOvertakenHorse];
        horsePosition[indexOfOvertakingHorse] = firstHorse;
        horsePosition[indexOfOvertakenHorse] = secondHorse;

        console.log(`${secondHorse} retakes ${firstHorse}.`)

    }


}


}

horseRacing((['Onyx|Domino|Sugar|Fiona',
'Trouble Onyx',
'Retake Onyx Sugar',
'Rage Domino',
'Miracle',
'Finish'])
)
