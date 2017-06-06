def addOrMultiply(a: Int, b: Int, addition: Boolean): Int = addition match {
  case true => a + b
  case _ => a * b
}

addOrMultiply(1, 2, true: Boolean)
addOrMultiply(1, 2, false: Boolean)



def addOrMultiplyWithZeroCheck(a: Int, b: Int, add: Boolean): Int = (a, b, add) match {
  case (0, 0, true|false) => 0
  case (0, b, true|false) => b
  case (a, 0, true|false) => a
  case (a, b, true) => a + b
  case _ => a * b
}

addOrMultiplyWithZeroCheck(0, 5, true)
addOrMultiplyWithZeroCheck(3, 0, false)
addOrMultiplyWithZeroCheck(1, 2, true)
addOrMultiplyWithZeroCheck(1, 2, false)
addOrMultiplyWithZeroCheck(0, 0, false)
