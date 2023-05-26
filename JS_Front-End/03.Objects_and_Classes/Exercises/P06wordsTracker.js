function wordsTrucker(input){
    let searchedWords = input.shift().split(' ');
    let words = {};

    for (const word of searchedWords) {
        
        let count = input.filter((w) => w === word).length;
        words[word] = count;

    }
    
  let sortedWords = Object.entries(words);

  sortedWords.sort((wordA, wordB) => wordB[1] - wordA[1]).forEach((w) => console.log(`${w[0]} - ${w[1]}`))



}

wordsTrucker([
    'this sentence', 
    'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurrences', 'of', 'the', 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
    )