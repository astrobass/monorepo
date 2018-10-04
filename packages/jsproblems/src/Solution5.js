var expect = require('chai').expect;

var problemStatement = "This problem was asked by Jane Street.\n\
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.\n\
Given this implementation of cons:\n\
def cons(a, b):\n\
    def pair(f):\n\
        return f(a, b)\n\
    return pair\n\
Implement car and cdr.";

console.log();
console.log(problemStatement);
console.log();

function cons(a, b) {
  var pair = f => { return f(a, b); };
  return pair;
}

function car(pair) {
  console.log(pair.a);
  return pair((a,b) => { return a });
}

function cdr(pair) {
  return pair((a,b) => { return b });
}

describe('car', function() {
  it('check car', function() {
    expect(car(cons(3, 4))).to.be.equal(3);
  });
});

describe('cdr', function() {
  it('check cdr', function() {
    expect(cdr(cons(3, 4))).to.be.equal(4);
  });
});
