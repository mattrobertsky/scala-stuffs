/*
  THIS FILE IS JUST FOR PLAYING AROUND AND DOESN'T ADDRESS ANY PARTICULAR EXERCISE
 */

// optional return??


def optionalReturn(): Option[String] = {
  Option("bar")
  //Option(null)
}


// three ways to get a value... or not (tis optional)
println(optionalReturn().getOrElse("foo"))
println(optionalReturn().map(result => result).getOrElse("foo"))
optionalReturn() match {
  case None => println("nil")
  //case some => println(some.get)
  case Some(a) => println(a)
}

// implicit val is a global?
// TODO test properly when we do garage

// prevent override of implicit val (globals) - they don't know if that's possible
// TODO investigate preventing implicits being overridden by function calls i.e. how to stop the below


implicit val foo = "foo"

def someFunc(bar: String) (implicit foo: String): String = {
  foo.concat(bar)
}

someFunc("bar") ("w00t")

// implicit classes let you add functions/methods to classes that you cannot otherwise modify
implicit class BetterString(word: String) {
  def goldPlated() = {
    println(s"this $word is gold plated")
  }
}
val doorKnob = "doorknob"
doorKnob.goldPlated()

// variable arg functions i.e. functions that can accept differing numbers of arguments
// T is a generic whereas Any is a super
// T* in constructor creates a list of generics - this also works with non generics e.g.
def variableLengthArgs(items: Int*) = {
  items.sum
}
variableLengthArgs(1, 2, 3)
// N.B. the generic version has to specify the argument type in [] before the args
def variableLengthArgs[T](items: T*) = {
  items.foreach(item => println(item))
}
// TODO investigate the difference between generics (T) and Any

def myFunc(any: Any) = {
  any match {
    case a: String => a*5
    case a: Int => a*5
    case _ => "no match"
  }
}

// the point here is that you can call any of the generic methods on T but with Any you need
// to figure out the type first
def myOtherFunc[T](any: T) = {
  any match {
    case a: T => a + "a"
  }
}
myOtherFunc("sas")
myOtherFunc(5)

// tuples
val tuple = ("one", 2, 3, 4, "five")
tuple._5
tuple.productElement(0)
tuple.productIterator.foreach(element => println(element))
// TODO not really understanding the Tuple1 -> N classes, unable to do anything with them
// tuple matching.. you can use the number of elements in the tuple as a case
/*
case (a,b,c) =>
case (a,b,c,d) =>
 */


// quantum entanglement
// closure ??
// referential transparency
// pure functions have no IO as it's an effect NOT a result, it is really a form of state
