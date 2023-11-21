// // Functions and Callback Handler

function callback(text) {
    console.log(`${text}`)
};
function onError(x) {
  console.log(`Error: "${x}" is catched`);
}
function callbackHandlerTimeoutPromise(callbackInput,text, time) {
  return new Promise((resolve, reject) => {
  try{
    throw new Error('"Error inside handler"');
    setTimeout(() => {
    callbackInput(text);
    resolve();
  }, time);
  } catch(error) {
    reject();
  }}
  );
}

callbackHandlerTimeoutPromise(console.log,"1. item", 3000).then(() =>
callbackHandlerTimeoutPromise(console.log,"2. item", 1000)).then(() =>
console.log("3. item")).catch(onError);