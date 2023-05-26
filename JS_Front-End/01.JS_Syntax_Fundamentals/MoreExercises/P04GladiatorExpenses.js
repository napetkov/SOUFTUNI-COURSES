function gladiatorExpenses(
  lostFightCount,
  helmetPrice,
  swordPrice,
  shieldPrice,
  armorPrice
) {
  let totalExpenses = 0;

  let brokenHelmetCount = Math.floor(lostFightCount / 2);
  let brokenSwordCount = Math.floor(lostFightCount / 3);
  let brokenShieldCount = Math.floor(lostFightCount / 6);
  let brokenArmorCount = Math.floor(lostFightCount / 12);

  totalExpenses =
    brokenHelmetCount * helmetPrice +
    brokenSwordCount * swordPrice +
    brokenShieldCount * shieldPrice +
    brokenArmorCount * armorPrice;

    console.log(`Gladiator expenses: ${totalExpenses.toFixed(2)} aureus`);
}

gladiatorExpenses(7,
    2,
    3,
    4,
    5
    );
    gladiatorExpenses(23,
        12.50,
        21.50,
        40,
        200
        );

