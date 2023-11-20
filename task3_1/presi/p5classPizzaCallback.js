// Using a constructor function

class Pizza{
  constructor(namePizza) {
    this.namePizza = namePizza;
    this.baked = () => console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
    this.bakingPizza = function() {
      console.log(`Ordering pizza: ${this.namePizza}`);
      this.callbackHandlerTimeout(console.log,"pizza arrived!", 3000)
      console.log('Waiting for pizza, doing sth else');
    }
    }
}
Pizza.prototype.callback = (text) => console.log(`${text}`);
Pizza.prototype.callbackHandlerTimeout = (callbackInput,text, time) => setTimeout(() => callbackInput(text), time);

function callback(text) { 
  console.log(`${text}`)
};
function callbackHandlerTimeout(callbackInput,text, time) {
  setTimeout(() => callbackInput(text), time);
}



const pizza = new Pizza("Salami");

pizza.bakingPizza();
callbackHandlerTimeout(console.log,"pizza arrived![outside class]", 3000)
