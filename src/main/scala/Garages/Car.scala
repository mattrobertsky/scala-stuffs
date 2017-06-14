package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
class Car (theReg: String, theOwner: Person) extends Vehicle {
  val registration: String = theReg
  val owner: Person = theOwner
  var working: Boolean = true
  override def myToString: String = s"Car $registration. Owner: ${owner.id} Manifest: \n${this.brokenPartManifest()} \nTOTAL fixTime: ${this.getHoursToFix()}\n\n"
}
