function inventory(input){
    let heroes = [];

    for (const line of input) {
        
        let [ hero, level, items] = line.split(' / ');
        level = Number(level);
        heroes.push({ hero, level, items})
    }

let sortedHeroes = heroes
.sort((heroA, heroB) => heroA.level - heroB.level);
// Hero: Hes
// level => 1
// items => Desolator, Sentinel, Antara

sortedHeroes.forEach((h) =>{
    console.log(`Hero: ${h.hero}`);
    console.log(`level => ${h.level}`);
    console.log(`items => ${h.items}`);
})

}

inventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]
    )