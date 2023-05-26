function cats(input) {
  class Cat {
    constructor(name, age) {
      this.name = name;
      this.age = age;
    }

    meow() {
      console.log(`${this.name}, age ${this.age} says Meow`);
    }
  }

  let catsArr = [];

  for (const catData of input) {
    let [name, age] = catData.split(" ");
    catsArr.push(new Cat(name, age));
  }

  return catsArr.forEach((cat) => cat.meow());
}

cats(["Mellow 2", "Tom 5"]);
