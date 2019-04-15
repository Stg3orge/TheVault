//Testing callbacks
function CompleteOrder() {
  console.log("Completing the order");
}

function ProcessOrder(doCompleteOrder) {
  //look at inventory
  console.log("Checking inventory...");
  //verify valid delivery address
  console.log("Validating delivery address");
  //invoke the callback
  doCompleteOrder();
}

ProcessOrder(CompleteOrder);
