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
  var workDone:Double = 0

  def breakParts(): Unit = {
    // N.B. a for comprehension
    for (part: Part <- parts) part.broken = math.random() < 0.26
    // look some recursion!
    // check that some parts are broken as using random doesn't guarantee it
    if (parts.filter(_.broken).isEmpty) {
      breakParts()
    }
  }

  def brokenPartManifest() : String = {
    var manifest: String = ""
    //for (part: Part <- parts) manifest += s" ${part.getClass.getName} broken: ${part.broken} hoursToFix ${part.hoursToFix}\n"
    parts.filter(_.broken).foreach(part => manifest += s" ${part.getClass.getName} broken: ${part.broken} hoursToFix: ${part.hoursToFix} partCost: £${part.cost}\n")
    manifest
  }

  def getHoursToFix() : Double = {
    parts.filter(_.broken).map(value => value.hoursToFix).sum - workDone
  }

  def getCostOfPartsToFix() : Double = {
    parts.filter(_.broken).map(value => value.cost).sum
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