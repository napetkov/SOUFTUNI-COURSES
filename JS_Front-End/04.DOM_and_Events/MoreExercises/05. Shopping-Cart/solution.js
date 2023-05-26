function solve() {
 const addButton = Array.from(document.getElementsByClassName('add-product'));
 const checkOutButton = Array.from(document.getElementsByClassName('checkout'))[0];
 let textareaOutput = Array.from(document.getElementsByTagName('textarea'))[0];

 
 let products = new Set();
 let totalPrice = 0;


 addButton.forEach((btn) => {
   btn.addEventListener('click', addProduct);
 });

 checkOutButton.addEventListener('click', checkOutHandler);
 


 function checkOutHandler (){
   textareaOutput.value += `You bought ${Array.from(products.keys()).join(', ')} for ${totalPrice.toFixed(2)}.`
   addButton.map((btn) => btn.disabled = true);
   checkOutButton.disabled = true;
 }


function addProduct(event){
   let product = event.currentTarget.parentElement.parentElement;
   let productName = product.querySelector('.product-details .product-title').textContent;
   let productPrice = Number(product.querySelector('.product-line-price').textContent);

   products.add(productName);
   totalPrice += productPrice;
   
   textareaOutput.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`
} 
}