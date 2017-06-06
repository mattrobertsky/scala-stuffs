println("Hello World!")

var helloWorldVar = "Hello World!"

println(helloWorldVar)

def printMessage(theMessage: String): Unit = {
  println(theMessage)
}

printMessage("HelloWorld!")

def helloWorld(): String = {
  "Hello World!"
}

printMessage(helloWorld())

def passthrough(a: Any) = {
  a
}

passthrough(123.00)
passthrough("foo")
passthrough(123)
passthrough(true)

def endOfWordFrom(word: String, i: Int) = {
  word.substring(word.length - i)
}

endOfWordFrom("Hello", 3)

def mungeAndReplace(part1: String, part2: String, replaceThis: String, withThat: String) = {
  val joined = part1 + part2
  joined.replaceAll(replaceThis, withThat)
}

mungeAndReplace("Ha", "llo", "a", "e")

def addSomeInts(a: Int, b: Int): Int = {
  a + b
}

addSomeInts(1, 2)

def addOrMultiply(a: Int, b: Int, add: Boolean): Int = {
  if(add) {
    a + b
  } else {
    a * b
  }
}

addOrMultiply(1, 2, true)
addOrMultiply(1, 2, false)

def addOrMultiplyWithZeroCheck(a: Int, b: Int, add: Boolean): Int = {
  if ( a == 0 && b == 0)
    0
  else if (a == 0) {
    b
  } else if (b == 0) {
    a
  } else if(add) {
    a + b
  } else {
    a * b
  }
}

addOrMultiplyWithZeroCheck(0, 5, true)
addOrMultiplyWithZeroCheck(3, 0, false)
addOrMultiplyWithZeroCheck(1, 2, true)
addOrMultiplyWithZeroCheck(1, 2, false)
addOrMultiplyWithZeroCheck(0, 0, false)

def returnN(input: String, repeat: Int) = {
  for (i <- 1 to repeat) {
    println(input)
  }
}
returnN("Hi", 3)

def returnNRecursive(input: String, repeat: Int) {
  if(repeat > 1) {
    returnNRecursive(input, repeat -1)
  }
  println(input)
}
returnNRecursive("Hi Recursion", 3)

def stringRepeat(input: String, repeat: Int): Unit = {
  for (i <- 0 until repeat) print(input)
}

stringRepeat("one line ", 3)

def stringRepeatRecursive(input: String, repeat: Int) {
  if (repeat > 1) {
    stringRepeatRecursive(input, repeat -1)
  }
  print(input)
}

stringRepeatRecursive("one line recursive ", 3)


def rectangularPrint(input: String, repeat: Int) {
  for (i <- 0 until repeat) {
    stringRepeat(input, repeat)
    print("\n")
  }
}

rectangularPrint("H", 4)

def rectangularPrintRecursive(input: String, rows: Int, cols: Int) {
  if(rows > 1) {
    rectangularPrintRecursive(input, rows - 1, cols)
  }
  stringRepeatRecursive(input, cols)
  println()
}

rectangularPrintRecursive("X", 5, 5)

def fizzBuzz(a: String, b: String, c: Int): Unit = {
  for(i <- 1 to c) {
    fizzy(a, b, i)
  }
}

def fizzy(a: String, b: String, i: Int) = {
  if (i % 3 == 0 && i % 5 == 0) {
    println(a.concat(b))
  } else if (i % 3 == 0) {
    println(a)
  } else if (i % 5 ==0) {
    println(b)
  } else {
    println(i)
  }
}

fizzBuzz("fizz", "buzz", 15)


def fizzBuzzRecursive(a: String, b: String, c: Int): Unit = {
  if (c > 1) {
    fizzBuzzRecursive(a, b, c - 1)
  }
  fizzy(a, b, c)
}

fizzBuzzRecursive("fizz", "buzz", 15)