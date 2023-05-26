function orders(product, quantity) {
    
  function productPrice(product){
  
    switch (product) {
    case "coffee":
      return 1.5;
    case "water":
      return 1.0;
    case "coke":
      return 1.4;
    case "snacks":
      return 2.0;
    default:
      return "Invalid product";
  }
}

let totalPrice = productPrice(product) * quantity;
console.log(totalPrice.toFixed(2));


}

orders("water", 5);
orders("coffee", 2);