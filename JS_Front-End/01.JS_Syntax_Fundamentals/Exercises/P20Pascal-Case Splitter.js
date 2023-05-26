function pascalCaseSplitter(text) {
  let startIndexOfWord = 0;

  let arrayWithWordsUpperCase = text.split(/(?=[A-Z])/g);

  // for (let i = 1; i < text.length; i++) {
  //   let charAtIndexASCII = text.charCodeAt(i);

  //   if (charAtIndexASCII >= 65 && charAtIndexASCII <= 90) {
  //     let wordStartWithUpperCase = text.substring(startIndexOfWord, i);
  //     arrayWithWordsUpperCase.push(wordStartWithUpperCase);
  //     startIndexOfWord = i;
  //   }
  // }
  //   arrayWithWordsUpperCase.push(text.slice(startIndexOfWord));

  console.log(arrayWithWordsUpperCase.join(", "));
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');
// pascalCaseSplitter("Avatar");
