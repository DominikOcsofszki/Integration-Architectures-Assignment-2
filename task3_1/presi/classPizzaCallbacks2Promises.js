// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
      this.delay = function(t, val) {
        return new Promise(resolve => setTimeout(resolve, t, val));
    }
    this.bakingPizza = function() {
      console.log("bakingPizza:")
      this.delay(() => console.log("shopping!"), 5000);

      this.delay(() => console.log("shopping!"), 5000);
      this.delay(() => console.log("cutting!"), 3000);
      this.delay(() => console.log("baking!"), 2000);
      this.delay(() => this.baked(), 3000);
      console.log("All DONE![wrong order]");
    }

    }
}

const pizza = new Pizza("Salami");
pizza.bakingPizza();
// pizza.bakingPizzaFixed();