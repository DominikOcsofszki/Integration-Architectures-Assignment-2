



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

function orderEvaluationBonus(clientRanking, price, nrOfItems) {
    return ((price*nrOfItems)/10) * (1 + (5-clientRanking)/10);
}

function orderEvaluationBonusSum(arrOfsingleBonus) {
    let sum = 0;
    for(const singleBonus of arrOfsingleBonus) {
        sum += orderEvaluationBonus(...arrOfsingleBonus);
    }
    return sum;
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

console.log(orderEvaluationBonus([[1,1000,20]]))