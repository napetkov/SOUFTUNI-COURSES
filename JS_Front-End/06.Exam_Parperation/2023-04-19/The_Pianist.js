function thePianist(input){
    const numberOfPieces = Number(input.shift());
    let pieceMap = {};

    const commandParser = {
        Add: addPiece,
        Remove: removePiece,
        ChangeKey: changePieceKey,
    }


    for (let i = 0; i < numberOfPieces; i++) {
       const pieceInfo = input.shift();

       const [ piece, composer, key] = pieceInfo.split('|');
        pieceMap[piece] = {composer, key};
    }

    while(input[0] !== 'Stop'){
        const commandLine = input.shift().split('|');
        const command = commandLine.shift();

        commandParser[command](...commandLine);
    }

    for (const key in pieceMap) {
        console.log(`${key} -> Composer: ${pieceMap[key].composer}, Key: ${pieceMap[key].key}`);
     }

    function addPiece(piece, composer, key){
        if(pieceMap.hasOwnProperty(piece)){
            console.log(`${piece} is already in the collection!`)
        }else {
            pieceMap[piece] = {composer, key};
            console.log(`${piece} by ${composer} in ${key} added to the collection!`)
        }
    }

    function removePiece(piece){
        if(pieceMap.hasOwnProperty(piece)){
           delete pieceMap[piece];
           console.log(`Successfully removed ${piece}!`);
        }else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }

    function changePieceKey(piece, newKey){
        if(pieceMap.hasOwnProperty(piece)){
            pieceMap[piece].key = newKey;
        console.log(`Changed the key of ${piece} to ${newKey}!`);
        }else {
            console.log(`Invalid operation! ${piece} does not exist in the collection.`);
        }
    }



}

thePianist([
  '3',
  'Fur Elise|Beethoven|A Minor',
  'Moonlight Sonata|Beethoven|C# Minor',
  'Clair de Lune|Debussy|C# Minor',
  'Add|Sonata No.2|Chopin|B Minor',
  'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
  'Add|Fur Elise|Beethoven|C# Minor',
  'Remove|Clair de Lune',
  'ChangeKey|Moonlight Sonata|C# Major',
  'Stop'  
]
);