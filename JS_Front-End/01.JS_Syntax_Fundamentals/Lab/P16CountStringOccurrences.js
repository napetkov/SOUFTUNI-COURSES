function solve(text,word){
let counter = 0;

let textArr = [''];

textArr = text.split(' ');

for (let i = 0; i < textArr.length; i++) {
   if(textArr[i] === word) {
    counter++;
   }
    
}

console.log(counter);
}

solve('This is a word and it also is a sentence',
'is')