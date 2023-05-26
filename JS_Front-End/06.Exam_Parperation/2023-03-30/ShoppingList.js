function shoppingList(input) {
  let groceryList = input.shift().split("!");

  let commandParser = {
    Urgent: addItem,
    Unnecessary: removeItem,
    Correct: correctItem,
    Rearrange: rearrangeItem,
  };

  while (input[0] !== "Go Shopping!") {
    let commandLine = input.shift().split(" ");
    let command = commandLine.shift();

    commandParser[command](...commandLine);
  }

  console.log(groceryList.join(', '));

  function addItem(item) {
    if (!groceryList.includes(item)) {
      groceryList.unshift(item);
    }
  }

  function removeItem(item) {
    if (groceryList.includes(item)) {
      let index = groceryList.indexOf(item);
      groceryList.splice(index, 1);
    }
  }

  function correctItem(oldItem, newItem) {
    if (groceryList.includes(oldItem)) {
      let index = groceryList.indexOf(oldItem);
      groceryList[index] = newItem;
    }
  }

  function rearrangeItem(item) {
    if (groceryList.includes(item)) {
      let index = groceryList.indexOf(item);
      groceryList.splice(index, 1);
      groceryList.push(item);
    }
  }
}

// shoppingList([
//   "Tomatoes!Potatoes!Bread",
//   "Unnecessary Milk",
//   "Urgent Tomatoes",
//   "Go Shopping!",
// ]);

shoppingList([
  "Milk!Pepper!Salt!Water!Banana",
  "Urgent Salt",
  "Unnecessary Grapes",
  "Correct Pepper Onion",
  "Rearrange Grapes",
  "Correct Tomatoes Potatoes",
  "Go Shopping!",
]);
