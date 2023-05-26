function solve(text, startIndex, count) {
  let substring = "";
  substring = text.substring(startIndex, startIndex + count);

  console.log(substring);
}

solve('SkipWord', 4, 7);