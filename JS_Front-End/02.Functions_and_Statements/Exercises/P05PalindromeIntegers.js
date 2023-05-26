function palindrome(numbers) {
  // let numberToArrayOfDigits = (num) => Array.from(String(num), Number);

  // let arrOfArrOfDigits = numbers.map((num) => numberToArrayOfDigits(num));

  // function isPalindrome(digitArr) {
  //   let flagForPalindrome = true;

  //   for (let i = 0; i < digitArr.length / 2; i++) {
  //     if (digitArr[i] !== digitArr[digitArr.length - 1 - i]) {
  //       flagForPalindrome = false;
  //     }
  //   }

  //   return flagForPalindrome;
  // }

  // for (let i = 0; i < arrOfArrOfDigits.length; i++) {
  //      console.log(isPalindrome(arrOfArrOfDigits[i]));

  // }

  numbers.forEach((num) => {
    console.log(isPalindrome(num))
  });

  function isPalindrome(num) {
    let reversed = Number([...num.toString()].reverse().join(""));

    return num === reversed;
  }
}

// palindrome([123, 323, 421, 121]);
palindrome([32, 2, 232, 1010]);
