def doubleChar(word: String): String = {

  word.split("").map(value => value.concat(value)).mkString("")

}

doubleChar("aabb")

def getSandwich(word: String): String = word match {
  case x if x.substring(x.indexOf("bread") + "bread".length ).contains("bread")=> x.split("bread")(1)
  case _ => ""
}

def evenlySpaced(a: Int, b: Int, c: Int): Boolean = {
  val sorted = Array[Double](a.toDouble,b.toDouble,c.toDouble).sortWith(_ > _)
  val average = (sorted(0) + sorted(2)) /  2.0
  sorted(1) == average
}
evenlySpaced(4, 6, 3)

def fibonacci(n: Int): Int = {
  // adds the previous two numbers in a sequence that starts 0, 1 until it reaches the nth number
  // in the sequence
  // 0 = 0, 1 = 1, 2 = 1, 3 = 2, 4 = 3, 5 = 5, 6 = 8, 7 = 13 etc.

  if (n == 0 || n == 1) {
    n
  } else {
    fibonacci(n - 1) + fibonacci(n - 2)
  }
}
fibonacci(5)

def bunnyEars(b: Int): Int = {
  println(s"bunnies: $b")
  // iterate bunnies returning two each time

  if (b < 1 ) {
    0
  } else {
    bunnyEars(b -1) * 2
  }
}
bunnyEars(5)

0 * 2


def nTwice (word: String, i: Int): String = {
  word.substring(0, i).concat(word.substring(word.length - i))
}

// TODO use match if time
def endsLy(word: String): Boolean ={
  if (word.length >= 2) {
    word.substring(word.length - 2).equals("ly")
  } else {
    false
  }
}

def stringClean(word: String): String = {
  word.toSet.mkString("")
}
stringClean("hello")

def outputDiamand(width: Int): Unit = {

}
outputDiamand(10)