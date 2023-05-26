function solve(countPeople, groupType, day) {
  let priceForPerson = 0;

  switch (groupType) {
    case "Students":
      if (day === "Friday") {
        priceForPerson = 8.45;
      } else if (day === "Saturday") {
        priceForPerson = 9.8;
      } else if (day === "Sunday") {
        priceForPerson = 10.46;
      }
      break;
    case "Business":
      if (day === "Friday") {
        priceForPerson = 10.9;
      } else if (day === "Saturday") {
        priceForPerson = 15.6;
      } else if (day === "Sunday") {
        priceForPerson = 16.0;
      }
      break;
    case "Regular":
      if (day === "Friday") {
        priceForPerson = 15.0;
      } else if (day === "Saturday") {
        priceForPerson = 20.0;
      } else if (day === "Sunday") {
        priceForPerson = 22.5;
      }
      break;
  }

  let totalAmount = countPeople * priceForPerson;

  if (countPeople >= 30 && groupType === "Students") {
    totalAmount = totalAmount * 0.85;
  }else if(countPeople >= 100 && groupType === "Business"){
    totalAmount = totalAmount - totalAmount/countPeople*10;
  }else if(countPeople >= 10 && countPeople <= 20 && groupType === "Regular"){
    totalAmount = totalAmount*0.95;
  }

  console.log(`Total price: ${totalAmount.toFixed(2)}`)

}

solve(40,
    "Regular",
    "Saturday"    
    )