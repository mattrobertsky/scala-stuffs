package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Bike(theReg: String, theOwner: Person) extends Vehicle {
  val registration: String = theReg
  val owner: Person = theOwner
  var working: Boolean = true
  def myToString: String = s"Bike $registration. Owner: ${owner.id} Manifest: \n${this.brokenPartManifest()} \nTOTAL fixTime: ${this.getHoursToFix()}"

}
