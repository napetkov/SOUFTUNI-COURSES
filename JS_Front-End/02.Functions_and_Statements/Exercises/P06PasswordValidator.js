function passwordValidator(password){

const validLength = (password) => password.length >= 6 && password.length <= 10;
const validLetterAndDigit = password => (/^[A-Za-z0-9]*$/g).test(password);
const validTwoDigits = password => {
    let numberOfDigits = password
    .split('')
    .filter((symbol) => !isNaN(symbol))       //(/[0-9]/g).test(symbol)
    .length;

    return numberOfDigits >= 2;
}

let flagForValidPassword = true;
let errorMassage = '';

if(!validLength(password)){
    errorMassage += 'Password must be between 6 and 10 characters \n';
    flagForValidPassword = false;
}

if(!validLetterAndDigit(password)){
    errorMassage += "Password must consist only of letters and digits \n";
    flagForValidPassword = false;
}

if(!validTwoDigits(password)){
    errorMassage += "Password must have at least 2 digits \n"
    flagForValidPassword = false;
}

return flagForValidPassword ? "Password is valid" : errorMassage;
}

console.log(passwordValidator('MyPa#ss123'));