var expect = require('chai').expect;

var problemStatement = "This problem was asked by Uber. Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i. For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]. Follow-up: what if you can't use division?";
console.log();
console.log(problemStatement);

function missingProduct(input, index) {
  var product = 1;
  var result = [];
  for( var i=0; i<input.length; i++ ) {
    product *= input[i];
  }
  for( var j=0; j<input.length; j++ ) {
    result[j] = product/input[j];
  }
  return result;
}

describe('missingProduct', function() {
  it('five entries', function() {
    var input = [1, 2, 3, 4, 5];
    var result = missingProduct(input);
    expect(result).to.deep.equal([120, 60, 40, 30, 24]);
  });
});

describe('missingProduct', function() {
  it('three entries', function() {
    var input = [3, 2, 1];
    var result = missingProduct(input);
    expect(result).to.deep.equal([2, 3, 6]);
  });
});
