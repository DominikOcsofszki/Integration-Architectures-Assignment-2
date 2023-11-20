

function orderEvaluationBonus(clientRanking, price, nrOfItems) {
    return ((price*nrOfItems)/10) * (1 + (5-clientRanking)/10);
}

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

function orderEvaluationBonusSum(arrOfsingleBonus) {
    let sum = 0;
    for(const singleBonus of arrOfsingleBonus) {
        sum += orderEvaluationBonus(...arrOfsingleBonus);
    }
    return sum;
}
// function socialPerformanceBonusSumArr(arrOfSocialPerformanceBonus) {
//     let sum = 0;
//     for(const singleBonus of arrOfSocialPerformanceBonus) {
//         sum += socialPerformanceBonus(
//             singleBonus[targetValue],
//             singleBonus[actualValue],
//             );
//     }
//     return sum;
// }
function orderEvaluationBonusSum(arrOfsingleBonus) {
    let sum = 0;
    for(const singleBonus of arrOfsingleBonus) {
        sum += orderEvaluationBonus(
            singleBonus[clientRanking],
            singleBonus[price],
            singleBonus[nrOfItems]
            );
    }
    return sum;
}

function socialPerformanceBonusSum2(arrOfSocialPerformanceBonus) {
    let sum = 0;
    for(const singleBonus of arrOfSocialPerformanceBonus) {
        sum += socialPerformanceBonus(...singleBonus

            );
    }
    return sum;
}

console.log(socialPerformanceBonusSum([[5,4], [5,5]]));
// console.log(orderEvaluationBonusSum())
console.log(socialPerformanceBonus(5,4));
console.log(socialPerformanceBonus(5,5));