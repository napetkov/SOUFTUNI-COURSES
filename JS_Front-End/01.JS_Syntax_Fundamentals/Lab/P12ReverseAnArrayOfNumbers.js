function solve(n, inputArr) {
  let arr = [];

  for (let i = 0; i < n; i++) {
    arr.push(inputArr[i]);

  }
  let outputArr = arr.reverse();
                

  console.log(outputArr.join(' '))
}

solve(3, [10, 20, 30, 40, 50])