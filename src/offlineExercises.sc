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
  println(s"n is $n")
  if (n >= 2) {
    fibonacci(n -1) + fibonacci(n-2)
  }
  0

}
fibonacci(5)

def bunnyEars(b: Int): Int = {
  def bar(b: Int, c: Int) {
    if (b>0) {
      bar((b-1), (c+2))
    }

  }
  if (b > 0 ) {
    bunnyEars(b - 1 )
  }
  2
}
bunnyEars(3)


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