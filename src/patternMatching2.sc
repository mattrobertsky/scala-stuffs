import java.util

def switchAroo(numbers: Any): Any = numbers match {
  case list: List[Int] if list.length > 2 => list.take(2).reverse
  case list: List[Int] => list.reverse
  case array: Array[Int] => array.reverse
  case tuple: (Int, Int) => tuple.swap
  case _ => numbers
}

val list = List(1,2)
switchAroo(list)

val array = Array(1,2)
switchAroo(array)

val tuple = (1,2)
switchAroo(tuple)

val longList = List(1,2,3,4)
switchAroo(longList)


