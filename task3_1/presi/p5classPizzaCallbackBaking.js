// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    
    this.baked = () => console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
    // this.shopping = () => console.log("shopping");
    // this.cutting = () => console.log("cutting");
    this.baking = () => console.log("baking");
    this.eating = () => console.log("eating");

    this.bakingPizza = function() {
      this.callbackHandlerTimeout(console.log,"start baking", 0);
      // this.callbackHandlerTimeout(this.shopping,"", 3000);
      // this.callbackHandlerTimeout(this.cutting,"", 3000);
      this.callbackHandlerTimeout(this.baking,"", 3000);
      this.callbackHandlerTimeout(this.eating,"", 3000);
    }
    }
}
Pizza.prototype.callback = (text) => console.log(`${text}`);
Pizza.prototype.callbackHandlerTimeout = (callbackInput,text, time) => setTimeout(() => callbackInput(text), time);

const pizza = new Pizza("Salami");

pizza.bakingPizza();
