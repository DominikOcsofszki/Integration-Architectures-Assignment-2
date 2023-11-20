// // Using a constructor function

// class Pizza{
//   constructor(namePizza) {
//     this.namePizza = namePizza;
//     this.baked = function() {
//         console.log(`${this.namePizza} Pizza baked [constructor:baked function]`);
//       };
//       this.delay = t => new Promise(resolve => setTimeout(resolve, t));
//     this.bakingPizza = function() {
//       console.log("bakingPizza:")
//       this.delay(() =>console.log("shopping!"), 5000))
//       const baking = await this.delay(() => console.log("shopping!"), 5000).then(
//       this.delay(() => console.log("shopping!"), 5000)).then(
//       this.delay(() => console.log("cutting!"), 3000)).then(
//       this.delay(() => console.log("baking!"), 2000)).then(
//       this.delay(() => this.baked(), 3000)).then(
//       console.log("All DONE![wrong order]"));
//     }

//     }
// }

// const pizza = new Pizza("Salami");
// await pizza.bakingPizza();
// // pizza.bakingPizzaFixed();