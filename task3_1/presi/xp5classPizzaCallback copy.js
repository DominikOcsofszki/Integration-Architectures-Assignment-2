// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = () => console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
    
    this.orderPizza = function() {
      console.log(`Ordering pizza: ${this.namePizza}`);
      setTimeout(() => console.log("pizza arrived!"), 3000);
      console.log('Waiting for pizza, doing sth else');
    }
    }
}

const pizza = new Pizza("Salami");

pizza.orderPizza();
