// Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
function callbackHandlerTimeout(callbackFunction,text, time) {
    setTimeout(() => callbackFunction(text), time);
}

callbackHandlerTimeout(console.log,"1. item", 3000);
callbackHandlerTimeout(callback,"2. item", 3000);
console.log("3. item");
