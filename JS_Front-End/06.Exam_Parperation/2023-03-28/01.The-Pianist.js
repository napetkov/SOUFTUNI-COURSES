function thePianist(input) {
  let n = Number(input.shift());
  let piecesCollection = {};
  let commandParser = {
    Add: addPiece,
    Remove: removePiece,
    ChangeKey: changeKey,
  };

  for (let i = 0; i < n; i++) {
    let commandLine = input.shift().split("|");
    [piece, composer, key] = commandLine;
    piecesCollection[piece] = { composer, key };
  }

  while (input[0] !== "Stop") {
    let commandLine = input.shift().split("|");
    let command = commandLine[0];
    commandParser[command](...commandLine.slice(1));
    }

    for (const piece in piecesCollection) {
       const {key, composer} = piecesCollection[piece];

       console.log(`${piece} -> Composer: ${composer}, Key: ${key}`)

    }

  function addPiece(piece, composer, key) {
    if (piecesCollection.hasOwnProperty(piece)) {
      console.log(`${piece} is already in the collection!`);
    } else {
      piecesCollection[piece] = { composer, key };
      console.log(`${piece} by ${composer} in ${key} added to the collection!`);
    }
  }
  function removePiece(piece) {
    if (piecesCollection.hasOwnProperty(piece)) {
        delete piecesCollection[piece];
      console.log(`Successfully removed ${piece}!`);
    } else {
      console.log(
        `Invalid operation! ${piece} does not exist in the collection.`
      );
    }
  }
  function changeKey(piece, newKey) {
    if (piecesCollection.hasOwnProperty(piece)) {
      piecesCollection[piece].key = newKey;
      console.log(`Changed the key of ${piece} to ${newKey}!`);
    } else {
      console.log(
        `Invalid operation! ${piece} does not exist in the collection.`
      );
    }
  }
}

thePianist([
  "3",
  "Fur Elise|Beethoven|A Minor",
  "Moonlight Sonata|Beethoven|C# Minor",
  "Clair de Lune|Debussy|C# Minor",
  "Add|Sonata No.2|Chopin|B Minor",
  "Add|Hungarian Rhapsody No.2|Liszt|C# Minor",
  "Add|Fur Elise|Beethoven|C# Minor",
  "Remove|Clair de Lune",
  "ChangeKey|Moonlight Sonata|C# Major",
  "Stop",
]);
