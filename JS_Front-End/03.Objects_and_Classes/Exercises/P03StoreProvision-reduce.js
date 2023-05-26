function storeProvision(stock, orderProducts) {
    let combined = [...stock, ...orderProducts];
    let store = combined.reduce((data,currentValue,index) => {
        if (index % 2 === 0) {
            if (!data.hasOwnProperty(currentValue)) {
              data[currentValue] = Number(combined[index + 1]);
            }else{
             let value = Number(combined[index + 1]);
              data[currentValue] += value;
            }
          }


        return data;
    },{});

  
  Object.entries(store).forEach(([product,value]) => console.log(`${product} -> ${value}`));
  }
  
  storeProvision(
    ["Chips", "5", "CocaCola", "9", "Bananas", "14", "Pasta", "4", "Beer", "2"],
    ["Flour", "44", "Oil", "12", "Pasta", "7", "Tomatoes", "70", "Bananas", "30"]
  );
  