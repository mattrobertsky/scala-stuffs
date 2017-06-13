package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Employee(nino:String) extends Person {
  val id: String  = nino
  override def myToString: String = s"Employee (national insurance number: $nino"


}

object Employee {
  object EmployeeFactory {
    var index: Int = 0
    def next(): Employee = {
      index += 1
      new Employee("E-".concat(index.toString))
    }
  }
}
