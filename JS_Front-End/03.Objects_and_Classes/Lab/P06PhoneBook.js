function phoneBook(data) {
  let phoneBookByNames = {};

  for (const line of data) {
    let [name, phoneNumber] = line.split(" ");

    phoneBookByNames[name] = phoneNumber;
  }

  Object.entries(phoneBookByNames).forEach(([key,value]) => console.log(`${key} -> ${value}`));



}

phoneBook([
  "Tim 0834212554",
  "Peter 0877547887",
  "Bill 0896543112",
  "Tim 0876566344",
]);
