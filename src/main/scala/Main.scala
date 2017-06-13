import java.util.Scanner

import Garages._

/**
  * Created by Administrator on 05/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {

    // TODO migrate this to a test
//    val bikeCustomer = new Customer("VR46")
////    val car1 = new Car("YDW 425",new Customer("MJR123"))
////    val car2 = new Car("HJ02TPV", new Customer("SR234"))
//    val bike1 = new Bike("GOF45T", bikeCustomer)
//    bike1.breakParts()
//    bike1.partManifest()
//    bike1.getHoursToFix()
//    val bike2 = new Bike("GO5L0W", bikeCustomer)

    //val vehicleMap = scala.collection.mutable.Map(car1.registration -> car1, car2.registration -> car2, bike1.registration -> bike1, bike2.registration -> bike2)

    var employees = scala.collection.mutable.Map[String, Employee]()
    for (i:Int <- (1 to 3)) {
      val employee = Employee.EmployeeFactory.next()
      employees += (employee.id ->employee)
    }
    val garage = new Garage(employees)
    garage.openGarage()
////    garage.vehicles = vehicleMap
//    garage.getContents()
    //garage.removeVehiclesByType(new Bike("DONE123", new Customer("CUL8R")))
//    garage.removeVehicle(car1)
//    //garage.vehicles.foreach(x=>println(x))
//    println("removing all bikes and one car")
//    garage.getContents()
//
//    bike1.breakParts()
//    println(bike1.partManifest())
//
//    println(bike1.parts.filter(_.broken).map(value => value.hoursToFix).sum)


    /* this is the number guessing thing
    var upperBound = 100
    var lowerBound = 0
    def guess(input: String = "higher", lastGuess: Int = 0, previousGuess: Int = 0): Int = {
      if (input == "higher") {
        lowerBound = lastGuess
        (upperBound + lastGuess) / 2
      } else  {
        upperBound = lastGuess
        (lowerBound + lastGuess) / 2
      }
    }



    System.out.println("Think of a number 1 to 100")
    var firstGuess = math.floor(math.random()* 100).toInt
    System.out.println(s"My guess is $firstGuess" )
    var lastGuess = 0
    def getChoice: String = {
      val line = readLine()
      val g: Int = guess(line, firstGuess)
      lastGuess = firstGuess
      firstGuess = g
      line match {
        case "correct" => println(s"Bye"); line
        case "boiling" => println(s"okay, how about ${lastGuess -1}"); getChoice
        case "freezing" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case "super cold" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case "super warm" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case _ => if (line == "higher" || line == "lower") println(s"how about $g"); getChoice
      }
    }
    val choiceType = getChoice
    */

  }
}
