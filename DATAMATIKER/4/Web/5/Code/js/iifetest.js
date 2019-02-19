//IIFE
(function() {
  var name = "Barry";
})();
// Variable name is not accessible from the outside scope
name; // undefined

var result = (function() {
  var name = "Barry";
  return name;
})();
// Immediately creates the output:
result; // "Barry"
