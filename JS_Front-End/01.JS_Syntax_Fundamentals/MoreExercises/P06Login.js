function login(inputArr) {
  let username = inputArr[0];

  let password = reverseString(username);

  let countLogins = 0;

  let outputMassage = "";

  for (let i = 1; i < inputArr.length; i++) {
    if (inputArr[i] === password) {
      outputMassage += `User ${username} logged in.`;
    } else {
      countLogins++;
      
      if (countLogins === 4) {
        outputMassage += `User ${username} blocked!`;
        break;
      }
      
      outputMassage += `Incorrect password. Try again.\n`;
    }
  }

  console.log(outputMassage);

  //Revers string by arr.revers
  function reverseString(str) {
    return str.split("").reverse().join("");
  }
  //Revers string by Recursion!!!
  // function reverseString(str) {
  //     return (str === '') ? '' : reverseString(str.substring(1)) + str.charAt(0);
  //   }
}

login(["sunny", "rainy", "cloudy", "sunny", "not sunny"]);
