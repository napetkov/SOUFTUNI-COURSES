function secretChat(input) {
  let massage = input.shift();

  const commandParser = {
    InsertSpace: insertSpace,
    Revers: reversSubstring,
    ChangeAll: changeAllSubstring,
  };

  while (input[0] !== "Reveal") {
    const commandLine = input.shift().split(":|:");
    [command, indexOrSubstring, replacement] = commandLine;
  
    commandParser[command](...commandLine.slice(1));
}

function insertSpace(index){
    const newMassage = massage.slice(0,index) + ' ' + massage.slice(index);
    massage = newMassage;
}

function reversSubstring(substring){
    if(massage.includes(substring)){
     const reversedMassage = substring.split('').reverse().join('');
     massage.replace(substring, '');
     massage += reversedMassage;  
    }  
}
function changeAllSubstring(substring, replacement){
    while(massage.includes(substring)){
        massage = massage.replace(substring,replacement);
    }
}
}

secretChat([
  "heVVodar!gniV",
  "ChangeAll:|:V:|:l",
  "Reverse:|:!gnil",
  "InsertSpace:|:5",
  "Reveal",
]);
