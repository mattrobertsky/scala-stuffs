/* anonymous functions are light weight functions that are useful if you want to do something
   in situ e.g. inside a .filter

  def nameFunc(i: Int): Boolean = {
    i % 2 == 0
  }

  is the same as

  (i: Int) => i % 2 == 0

   */

val x = List.range(1, 10)

x.filter(i => i % 2 == 0)
x.filter((i: Int) => i % 3 == 0)
x.filter((f: Int) => f > 5)

// anonymous function as a val
val anon = (i: Int) => i > 4
x.filter(anon)
// and without args TODO ask why this doesn't work
//val anonNoArg = _ => true
x.filter(_ => true)