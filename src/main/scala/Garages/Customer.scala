package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Customer(customerId:String) extends Person {
  val id:String = customerId
  override def myToString: String = s"Customer: $customerId"

}
object Customer {
  object CustomerFactory {
    var index: Int = 0
    def next(): Customer = {
      index += 1
      new Customer("C-".concat(index.toString))
    }
  }
}


