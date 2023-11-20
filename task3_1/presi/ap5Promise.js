// Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
function callbackHandlerTimeout(callbackInput,text, time) {
    setTimeout(() => callbackInput(text), time);
}

callbackHandlerTimeout(console.log,"1. item", 3000);
callbackHandlerTimeout(console.log,"2. item", 1000);
console.log("3. item");

//
      this.delayedText = function (text, time) {
        return new Promise((resolve) => {
          setTimeout(() => {
            console.log(`${text}`);
            resolve();
          }, time);
        });
      };