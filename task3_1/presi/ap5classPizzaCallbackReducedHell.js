// Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
function callbackHandlerTimeout(callbackFunction,text, time) {
    setTimeout(() => callbackFunction(text), time);
}

// callbackHandlerTimeout(callback,"1. item", 2000);
// callbackHandlerTimeout(callback,"2. item", 1000);
// callbackHandlerTimeout(callback,"3. item", 3000);
// callbackHandlerTimeout(callback,"4. item", 1000);
// console.log("3. item");

const hell = () => setTimeout(function () {
    console.log("1. item");setTimeout(function () {
        console.log("2. item");setTimeout(function () {
            console.log("3. item");setTimeout(function () {
                console.log("4. item");setTimeout(function () {
                    console.log("5. item");setTimeout(function () {
                        console.log("6. item");setTimeout(function () {
                            console.log("7. item");setTimeout(function () {
                                console.log("8. item");
                            }, 3000);
                        }, 1000);
                    }, 500);
                }, 500);
            }, 500);
        }, 500);
    }, 500);
}, 500);

hell();
