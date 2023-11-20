// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = function() {
        console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
      };
    this.orderPizza = function() {
      console.log(`Ordering pizza: ${this.namePizza}`);
      // setTimeout(() => console.log("pizza arrived!"), 3000);
      this.delayedText("pizza arrived!", 3000); // adding function as prototype
      console.log('Waiting for pizza, doing sth else');
    }
    }
}
Pizza.prototype.delayedText = function(text, time) {
  setTimeout(() => console.log(`${text}`), time);
}

const pizza = new Pizza("Salami");
pizza.orderPizza();