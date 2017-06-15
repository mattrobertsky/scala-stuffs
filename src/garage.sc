import Garages._


var employees = scala.collection.mutable.Map[String, Employee]()
for (i:Int <- (1 to 3)) {
  val employee = Employee.EmployeeFactory.next()
  employees += (employee.id ->employee)
}
val garage = new Garage(employees)

garage.openGarage()
garage.closeGarage()
