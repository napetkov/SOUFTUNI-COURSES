function storeProvision(stock, orderProducts) {
  let combined = [...stock, ...orderProducts];
  let store = {};

  for (let i = 0; i < combined.length; i++) {
    let property = combined[i];

    if (i % 2 === 0) {
      if (!store.hasOwnProperty(property)) {
        store[property] = Number(combined[i + 1]);
      }else{
       let value = Number(combined[i+1]);
        store[property] += value;
      }
    } else {
    }
  }

Object.entries(store).forEach(([product,value]) => console.log(`${product} -> ${value}`));
}

storeProvision(
  ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
  ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
);
