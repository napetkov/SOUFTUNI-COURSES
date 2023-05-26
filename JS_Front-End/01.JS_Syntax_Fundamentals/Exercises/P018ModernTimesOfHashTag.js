function modernTimeOfHashTag(text) {
  let textArr = text.split(" ");

  let resultArr = [];

  for (const word of textArr) {
    if (word.startsWith("#") && word.length > 1 && checkIfWordIsValid(word)) {
        let checkedWord = word.slice(1);
        resultArr.push(checkedWord);
    }
  }

  function checkIfWordIsValid(word) {
    let checkedWord = "";
    let isValid = true;
    for (let i = 1; i < word.length; i++) {
    //   console.log(word.toLowerCase().charCodeAt(i));
        if (
        word.toLowerCase().charCodeAt(i) < 97 ||
        word.toLowerCase().charCodeAt(i) > 122
      ) {
        isValid = false;
      }
    }
   return isValid;
  }
  console.log(resultArr.join("\n"));
}

modernTimeOfHashTag("#asdz #ad1asd #as67%d");

modernTimeOfHashTag(
  "Nowadays everyone uses # to tag a #special word in #socialMedia"
);
modernTimeOfHashTag(
    'The symbol # is known #variously in English-speaking #regions as the #number sign'
  );
