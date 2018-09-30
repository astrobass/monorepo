var expect = require('chai').expect;

var problemStatement = "This problem was recently asked by Google. Given a list of numbers and a number k, return whether any two numbers from the list add up to k. For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17. Bonus: Can you do this in one pass?";
console.log();
console.log(problemStatement);

function isAddUp(input, sum) {
  var compareList = [];

  for( var i=0; i<input.length; i++ ) {
    var element = input[i];
    if(compareList[sum-element]) {
      return true;
    } else {
      compareList[element] = 1;
    }
  }
  return false;
}

describe('isAddUp()', function () {
  it('should match once', function () {
    var input = [10, 15, 3, 7];
    var sum = 17;
    result = isAddUp(input, sum);
    expect(result).to.be.equal(true);
  });

  it('should not match', function() {
    var input = [10, 15, 3, 7];
    var sum = 30;
    result = isAddUp(input, sum);
    expect(result).to.be.equal(false);
  });
});
