var expect = require('chai').expect;

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
