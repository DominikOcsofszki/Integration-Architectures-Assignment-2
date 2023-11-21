// // Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
// function callbackHandlerTimeout(callbackInput,text, time) {
//     setTimeout(() => callbackInput(text), time);
// }

// callbackHandlerTimeout(console.log,"1. item", 3000);
// callbackHandlerTimeout(console.log,"2. item", 1000);
// console.log("3. item");

function callbackHandlerTimeoutPromise(callbackInput,text, time) {
  return new Promise((resolve, reject) => {
    // if(cond) reject();
  setTimeout(() => {
    callbackInput(text);
    resolve();
  }, time);
  });
}
function onError() {
  console.log("Error is catched");
}
//async/await
async function asyncFunction(){
  await callbackHandlerTimeoutPromise(console.log,"1. item", 3000);
  await callbackHandlerTimeoutPromise(console.log,"2. item", 1000);
  await console.log("3. item");
}
asyncFunction();