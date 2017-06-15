package Garages


import scala.util.Random

/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Vehicle extends ToStringAble {

  val registration: String
  var working: Boolean
  val owner: Person
  val parts: List[Part] = Part.Factory.getParts
  var workDone:Double = 0

  def breakParts(): Unit = {
    // N.B. a for comprehension (yay)
    for (part: Part <- parts) part.broken = math.random() < 0.1
    // look some recursion!
    if (parts.filter(_.broken).isEmpty) {
      breakParts
    }
  }

  def brokenPartManifest() : String = {
    var manifest: String = ""
    parts.filter(_.broken).foreach(part => manifest += s"     ${part.getPartType}, hours to fix: ${part.hoursToFix}, cost of part: £${part.cost}.\n")
    manifest
  }

  def getHoursToFix : Double = {
    parts.filter(_.broken).map(value => value.hoursToFix).sum - workDone
  }

  def getCostOfPartsToFix : Double = {
    parts.filter(_.broken).map(value => value.cost).sum
  }

  def getPartType: String = {
    this.getClass.getName.replace("Garages.Part$Factory$", "")
  }
}
object Vehicle {

  object BrokenVehicleQueue {
    var index = 0

    def next(): Vehicle = {
      index += 1

      def nextRegNo: String = {
        Random.alphanumeric.take(6).mkString("").concat(index.toString).toUpperCase
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