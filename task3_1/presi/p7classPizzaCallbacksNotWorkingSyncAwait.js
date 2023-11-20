// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
    this.delayedText = function(text, time) {
      setTimeout(() => console.log(`${text}`), time);
    }

    this.bakingPizza = async function() {
      console.log("bakingPizza:")
      await this.delayedText("shopping!", 4000);
      await this.delayedText("cutting!", 3000);
      await this.delayedText("baking!", 2000);
      await setTimeout(() => this.baked(), 3000);
      await console.log("All DONE![wrong order]");
    }
    }
}
Pizza.prototype.delayedText = function(text, time) {
  setTimeout(() => console.log(`${text}`), time);
}

const pizza = new Pizza("Salami");
pizza.bakingPizza();
// pizza.bakingPizzaFixed();