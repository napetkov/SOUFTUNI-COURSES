function BitcoinMining(amountOfGoldArr) {
  let priceForOneGramGold = 67.51;
  let priceForOneBitcoin = 11949.16;
  let totalAmountLeva = 0;
  let totalAmountBitcoin = 0;
  let isBoughtBitcoin = false;
  let dayOfFirstBitcoin = 0;


  for (let i = 0; i < amountOfGoldArr.length; i++) {
    let amountLevaPerDay = amountOfGoldArr[i] * priceForOneGramGold;
    
      let currantDay = i + 1;
    if (currantDay % 3 === 0 && i !== 0) {
      amountLevaPerDay -= amountLevaPerDay * 0.3;
    }
    totalAmountLeva += amountLevaPerDay;

    if(totalAmountLeva >= priceForOneBitcoin){
        if(isBoughtBitcoin === false){
            dayOfFirstBitcoin = currantDay;
        }

        isBoughtBitcoin = true;
        let boughtBitcoinForThisDay = Math.floor(totalAmountLeva / priceForOneBitcoin);
        totalAmountBitcoin += boughtBitcoinForThisDay;
        totalAmountLeva = totalAmountLeva % priceForOneBitcoin;
    }
  }

  console.log(`Bought bitcoins: ${totalAmountBitcoin}`);
 
  if(isBoughtBitcoin === true){
    console.log( `Day of the first purchased bitcoin: ${dayOfFirstBitcoin}`);
  }

  console.log(`Left money: ${totalAmountLeva.toFixed(2)} lv.`)

}

BitcoinMining([3124.15, 504.212, 2511.124]);