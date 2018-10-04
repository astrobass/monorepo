var expect = require('chai').expect;

var problemString = "This problem was asked by Stripe. Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well. For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3. You can modify the input array in-place.";
console.log(problemString);

function findMissingInt(input) {
  j=0;
  console.log(input);
  for( i=0; i<input.length; i++ ) {
    if( input[i] < 0 ) {
      tmp = input[i];
      input[i] = input[j];
      input[j] = tmp;
      j++;
    }
  }
  console.log(input);
  for( i=j; i<input.length; i++ ) {
    var num = Math.abs(input[i]);
    if( (j + num - 1 < input.length) && j + num - 1 >= 0 ) {
      input[j + num - 1] = -Math.abs(input[j + num - 1]);
    }
  }
  console.log(input);
  for( i=j; i<input.length; i++ ) {
    if( input[i] > 0 ) {
      return i - j + 1;
    }
  }
  return input.length;
}

describe('findMissingInt', function() {
  it('test four numbers', function() {
    var input = [3, 4, -1, 1];
    var result = findMissingInt(input);
    expect(result).to.be.equal(2);
  });

  it('test three numbers', function() {
    var input = [1, 2, 0];
    var result = findMissingInt(input);
    expect(result).to.be.equal(3);
  });
});

