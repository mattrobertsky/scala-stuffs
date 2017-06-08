/*
 case/match isn't very handy here as it's too easy to end up with tail recursion and to avoid it
 you need dead stubs

 the println here lets you see how the recursion stack first winds up, then winds out
 TODO reread the Mit-Scheme recursion explanation and the expand/substitute evaluate bit
*/

def fact1 (i: Int): Int = {
  i match {
    case i if i > 1 => {
      println(s"passing $i")
      fact1(i - 1)
    }
    case 1 => {
      // N.B. don't use matching for recursion!
    }
  }
  println(s"executing $i")
  i * (i-1)
}

fact1(5)

def fact2 (i: Int): Int = {
  if (i > 1) {
    println(s"passing $i")
    fact2(i-1)
  }
  println(s"executing $i")
  i * (i-1)
}
fact2(6)
