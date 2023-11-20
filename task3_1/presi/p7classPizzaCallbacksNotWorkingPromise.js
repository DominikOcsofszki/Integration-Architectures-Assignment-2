// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
    this.delayedText = function (text, time) {
      return new Promise((resolve) => {
        setTimeout(() => {
          console.log(`${text}`);
          resolve();
        }, time);
      });
    };

    this.bakingPizza = function() {
      console.log("bakingPizza:");

      this.delayedText("shopping!", 4000).then(
      this.delayedText("cutting!", 3000)).then(
      this.delayedText("baking!", 2000)).then(
      setTimeout(() => this.baked(), 3000)).then(
      console.log("All DONE![Still not CORRECT order]"));
    }
}
}
Pizza.prototype.delayedText = function(text, time) {
  setTimeout(() => console.log(`${text}`), time);
}

const pizza = new Pizza("Salami");
pizza.bakingPizza();
// pizza.bakingPizzaFixed();