function catalogueParser(input){
    let productObj = {};

    let catalogue = input.reduce((data, currentProduct) => {
    let firstChar = currentProduct.charAt(0);
    if(!data.hasOwnProperty(firstChar)){
        productObj = {};
    }else {
        productObj = data[firstChar];
    }
    
    let [product, productPrice] = currentProduct.split(' : ');
    productObj[product] = [productPrice];

    data[firstChar] = productObj;
    return data;
},{})

let sortedCatalogue = Object.entries(catalogue).sort((productA,productB) => productA[0].localeCompare(productB[0]));

sortedCatalogue.forEach(([ letter, product ]) => {
    console.log(letter);
    Object.entries(product)
    .sort((productA, productB) => productA[0].localeCompare(productB[0]))
    .forEach((p) => console.log(`  ${p[0]}: ${p[1]}`));
})
}

catalogueParser([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
    ]
    )