var expect = require('chai').expect;

var problemStatement = "This problem was asked by Facebook. Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded. For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.";


function getChar(input) {
  return String.fromCharCode("a".charCodeAt(0) + parseInt(input) - 1);
}

function encode(input, output, result) {
  if( input.length == 0 ) {
    result.push(output);
    return;
  }
  encode(input.substring(1), output + getChar(input.substring(0,1)), result);
  if( (input.length >= 2) && (parseInt(input.substring(0,2)) <= 26) ) {
    encode(input.substring(2), output + getChar(input.substring(0,2)), result);
  }
}


describe('encode', function() {
  it('threeTest', function() {
    var result = [];
    var input = "111";
    encode(input, "", result);
    console.log(result);
    expect(result).to.be.deep.equal([ "aaa", "ak", "ka" ]);
  });

  it('fourTest', function() {
    var result = [];
    var input = "1132";
    encode(input, "", result);
    console.log(result);
    expect(result).to.be.deep.equal([ "aacb", "amb", "kcb" ]);
  });
});
