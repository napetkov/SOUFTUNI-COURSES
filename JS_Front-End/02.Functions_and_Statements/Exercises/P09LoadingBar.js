function loadingBar(number){
    let percentSigns = '%'.repeat(number/10);
    let dotSigns = '.'.repeat(10-(number/10));

    if(number === 100){
        console.log(`${number}% Complete!`);
        console.log(`[${percentSigns}${dotSigns}]`)
    }else{
        console.log(`${number}% [${percentSigns}${dotSigns}]`)
        console.log('Still loading...')
    }
}

loadingBar(30);
loadingBar(40);
loadingBar(50);
loadingBar(60);
loadingBar(70);
loadingBar(80);
loadingBar(90);
loadingBar(100);
