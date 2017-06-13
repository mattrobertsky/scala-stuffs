package Garages

import Garages.Vehicle.BrokenVehicleQueue.{index}

import scala.util.Random

/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Vehicle extends ToStringAble {

  val registration: String
  var working: Boolean
  val owner: Person
  val parts: List[Part] = Part.Factory.getParts()

  def breakParts(): Unit = {
    // N.B. a for comprehension
    for (part: Part <- parts) part.broken = math.random() < 0.26
  }

  def partManifest() : String = {
    var manifest: String = ""
    for (part: Part <- parts) manifest += s" ${part.getClass.getName} broken: ${part.broken} hoursToFix ${part.hoursToFix}\n"
    manifest
  }

  def getHoursToFix() : Double = {
    parts.filter(_.broken).map(value => value.hoursToFix).sum
  }

}
object Vehicle {

  object BrokenVehicleQueue {
    var index = 0
    //val sequence: List[Int] = (1 until 100).toList

    def next(): Vehicle = {
      index += 1

      def nextRegNo: String = {
        Random.alphanumeric.take(6).mkString("").concat(index.toString.toUpperCase)
      }

      if (math.random() < .5) {
        val vehicle: Vehicle = new Car(nextRegNo, Customer.CustomerFactory.next())
        vehicle.breakParts()
        vehicle
      } else {
        val vehicle: Vehicle = new Bike(nextRegNo, Customer.CustomerFactory.next())
        vehicle.breakParts()
        vehicle
      }
    }
  }


}