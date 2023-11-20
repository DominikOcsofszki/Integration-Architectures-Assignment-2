// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
    this.delayedText = function(callback,text, time) {
      // setTimeout(() => console.log(`${text}`), time);
      setTimeout(() => callback(text), time);
    }
    this.func = (text) => console.log(`${text}`);

    this.bakingPizza = function() {
      console.log(this.func,"bakingPizza:")
      this.delayedText(this.func,"shopping!", 4000);
      this.delayedText(this.func,"cutting!", 3000);
      this.delayedText(this.func,"baking!", 2000);
      this.delayedText(this.baked,"baking!", 2000);

      // setTimeout(() => this.baked(), 3000);
      console.log("All DONE![wrong order]");
    }
    }
}
Pizza.prototype.delayedText = function(text, time) {
  setTimeout(() => console.log(`${text}`), time);
}

const pizza = new Pizza("Salami");
pizza.bakingPizza();
// pizza.bakingPizzaFixed();