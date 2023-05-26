function wordsUppercase(text){
    text = text.toUpperCase();

    wordsArr = text.split(/[!-\/\s]+/).filter(element => element);
    
    console.log(wordsArr.join(', '));
}

wordsUppercase('Hi, how are you?');
wordsUppercase('hello i.e. # % & )');