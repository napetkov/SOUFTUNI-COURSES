function fruit(fruitType,weightGrams,pricePerKG){

        let weightKG = weightGrams/1000;
        let totalPrice = weightKG*pricePerKG;

        console.log(`I need $${totalPrice.toFixed(2)} to buy ${weightKG.toFixed(2)} kilograms ${fruitType}.`);
}

fruit('orange', 2500, 1.80);
fruit('apple', 1563, 2.35)