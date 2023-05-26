function spiceMustFlow(yield) {
  let counterDays = 0;
  let spiceInStorage = 0;

  while (yield >= 100) {
    counterDays++;
    spiceInStorage += yield;
    spiceInStorage -= 26;
    yield -= 10;
  }

  if (counterDays > 0) {
    spiceInStorage -= 26;
  }
  console.log(counterDays);
  console.log(spiceInStorage);
}

spiceMustFlow(99);
spiceMustFlow(90);
