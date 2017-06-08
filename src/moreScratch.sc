// quantum entanglement
// closure ??
// referential transparency
// pure functions have no IO as it's an effect NOT a result, it is really a form of state

/*
 N.B. composition only handles single argument functions
 Also worth pointing out that the return type from each function needs to match the arg type of
 the next in the chain
  */

val funcOne = (arg: String) => {
  arg.length
}

val funcTwo = (arg1: Int) => {
  (arg1 % 2): Double
}

val funcThree = (arg: Double) => {
  arg < 100
}

val funcPrequel = (arg: String) => {
  arg concat "bar"
}

(funcOne andThen funcTwo andThen funcThree compose funcPrequel)("foo")

