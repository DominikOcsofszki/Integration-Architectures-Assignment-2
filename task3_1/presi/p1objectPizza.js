// Producing one Object
const pizzaObject = {
    namePizza : "Salami",
    baked : function() {
        console.log(`${this.namePizza} baked (:pizzaObject)`);
    },
}

pizzaObject.baked();
