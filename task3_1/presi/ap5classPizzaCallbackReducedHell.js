// Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
function callbackHandlerTimeout(callbackFunction,text, time) {
    setTimeout(() => callbackFunction(text), time);
}

callbackHandlerTimeout(callback,"1. item", 2000);
callbackHandlerTimeout(callback,"2. item", 1000);
callbackHandlerTimeout(callback,"3. item", 3000);
callbackHandlerTimeout(callback,"4. item", 1000);
// console.log("3. item");

setTimeout(function () {
    console.log("1. item");
    setTimeout(function () {
      callback("2. item");
    }, 3000);
  }, 3000);