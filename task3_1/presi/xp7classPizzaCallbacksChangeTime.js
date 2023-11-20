// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };

    this.bakingPizza = function() {
      console.log("bakingPizza:")
      setTimeout(() => console.log("shopping!"), 5000);
      setTimeout(() => console.log("cutting!"), 3000);
      setTimeout(() => console.log("baking!"), 2000);
      setTimeout(() => this.baked(), 3000);
      console.log("All DONE![wrong order]");
    }
    this.timeoutCallback = (printMe) => {
      console.log(`${printMe}`);
    };
    this.bakingPizzaFixWithCallbackHell = function() {
      this.timeoutCallback("bakingPizza:");
      setTimeout(() => console.log("shopping!"), 5000);
      setTimeout(() => console.log("shopping!"), 5000);
      setTimeout(() => console.log("cutting!"), 3000);
      setTimeout(() => console.log("baking!"), 2000);
      setTimeout(() => this.baked(), 3000);
      this.timeoutCallback("All DONE![wrong order]");

    }

    }
}
const fix = true

const pizza = new Pizza("Salami");
if (fix) {
  console.log("pizza.bakingPizzaFixWithCallbackHell();")
  pizza.bakingPizzaFixWithCallbackHell();
} else {
console.log("pizza.bakingPizza();")
pizza.bakingPizza();
}