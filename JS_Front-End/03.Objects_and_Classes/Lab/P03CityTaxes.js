function cityTaxes(name, population, treasury) {
    let cityInfo = {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes(){
            this.treasury += this.population * this.taxRate;
            this.treasury = Math.floor(this.treasury);
        } ,
        applyGrowth: function applyGrowth(percentage){
           this.population += this.population * percentage/100;
            this.population = Math.floor(this.population);
        },
        applyRecession: function applyRecession (percentage){
            this.treasury -= this.treasury * percentage/100;
            this.treasury = Math.floor(this.treasury);
        } 
    };
    return cityInfo;
};

const city =
  cityTaxes('Tortuga',
  7000,
  15000);
city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);

