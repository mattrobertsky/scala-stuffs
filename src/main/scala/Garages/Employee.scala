package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Employee(nino:String) extends Person {
  val id: String  = nino
  override def myToString: String = s"Employee (national insurance number: $nino"


}
