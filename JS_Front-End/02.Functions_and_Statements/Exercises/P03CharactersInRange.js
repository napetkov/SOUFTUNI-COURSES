function characterInRange(firstChar, secondCHar) {
  let lowerChar = Math.min(firstChar.charCodeAt(0), secondCHar.charCodeAt(0));
  let biggerChar = Math.max(firstChar.charCodeAt(0), secondCHar.charCodeAt(0));
  let characterArray = [];

  for (let i = lowerChar + 1; i < biggerChar; i++) {
    characterArray.push(String.fromCharCode(i));
  }

  console.log(characterArray.join(" "));
}

characterInRange("a", "d");
characterInRange("#", ":");
characterInRange("C", "#");
