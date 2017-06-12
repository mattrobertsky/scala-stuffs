package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Customer(customerId:String) extends Person {
  val id:String = customerId
  override def myToString: String = s"Customer: $customerId"
}
