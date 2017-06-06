def addOrMultiply(a: Int, b: Int, addition: Boolean): Int = addition match {
  case true => a + b
  case _ => a * b
}

addOrMultiply(1, 2, true: Boolean)
addOrMultiply(1, 2, false: Boolean)