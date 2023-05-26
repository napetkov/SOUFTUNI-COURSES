function stringSubstring(word, text){
   let wordToLowerCase = word.toLowerCase();
   let textToLowerCase = text.toLowerCase().split(' ');

   if(textToLowerCase.includes(wordToLowerCase)){
    return word;
   }else {
    return `${word} not found!`
   }
   
}

console.log(stringSubstring('javascript',
'JavaScript is the best programming language'
));

console.log(stringSubstring('python',
'JavaScript is the best programming language'
));