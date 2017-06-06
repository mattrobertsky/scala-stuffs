def uniqueSum(a: Int, b: Int, c: Int): Int = (a, b, c) match {
  case (a, b, c) if a == b && a == c => 0
  case (a, b, c) if a == b => c
  case (a, b, c) if a == c => b
  case (a, b, c) if b == c => a
  case _ => a + b + c
}

uniqueSum(1,2,3)
uniqueSum(1,1,2)
uniqueSum(3,3,3)

def uniqueSumWithMap(a: Int, b: Int, c: Int): Int = {
  var sum = 0
  var foo = List(a,b,c)
  foo.filter(p => foo.count(_ == p) == 1).foreach(item => sum += item)
  sum
}

uniqueSumWithMap(1,2,3)
uniqueSumWithMap(1,1,2)
uniqueSumWithMap(3,3,3)


// below here is just experiments
var s = List(4,4,9, 9).sorted
var t = scala.collection.mutable.ListBuffer[Int]()
var tally = 0
for (i <- 0 until s.length) {
  if(!t.toList.contains(s(i))) {
    t += s(i)
    tally += s(i)
  } else {
    //t -= s(i)
    tally -= s(i)
  }
}
t
tally

var sum = 0
var foo = List(3,3,3)
foo.filter(p => foo.count(_ == p) == 1).foreach(item => sum += item)
foo.count(_ == 5)

