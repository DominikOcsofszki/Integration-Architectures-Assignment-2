



function socialPerformanceBonus(targetValue,actualValue){
    const objectMap = {
        "-5":0,
        "-4":0,
        "-3":0,
        "-2":10,
        "-1":20,
        "0":50,
        "1":100,
        "2":125,
        "3":150,
        "4":150,
        "5":150,
    }
    // const diff = actualValue - targetValue
    return objectMap[actualValue - targetValue];
}



function socialPerformanceBonusSum(arrOfSocialPerformanceBonus) {
    let sum = 0;
    for(const singleBonus of arrOfSocialPerformanceBonus) {
        sum += socialPerformanceBonus(...singleBonus);
    }
    return sum;
}

console.log(socialPerformanceBonusSum([[5,4], [5,5]]));
// console.log(orderEvaluationBonusSum())
console.log(socialPerformanceBonus(5,4));
console.log(socialPerformanceBonus(5,5));

console.log(orderEvaluationBonusSum([[1,1000,20]]))
console.log("---------");
console.log(totalBonus(
    [[5,4], [5,5]],
    [[1,1000,20]]));
function orderEvaluationBonus(clientRanking, price, nrOfItems) {
    // console.log(clientRanking, price, nrOfItems);
    // console.log(clientRanking);
    return ((price*nrOfItems)/10) * (1 + (5-clientRanking)/10);
}

function orderEvaluationBonusSum(arrOfsingleBonus) {
    let sum = 0;
    for(const singleBonus of arrOfsingleBonus) {
        sum += orderEvaluationBonus(...singleBonus);
    }
    return sum;
}

function totalBonus(listOfOrderEvaluation, listOfSocialPerformanceEvaluation) {
    console.log(listOfOrderEvaluation);
    console.log(orderEvaluationBonusSum(listOfOrderEvaluation));
    console.log(socialPerformanceBonusSum(listOfSocialPerformanceEvaluation));

}