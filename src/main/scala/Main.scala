import Garages._

/**
  * Created by Administrator on 05/06/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {

    // TODO migrate this to a test
    val bikeCustomer = new Customer("VR46")
    val car1 = new Car("YDW 425",new Customer("MJR123"))
    val car2 = new Car("HJ02TPV", new Customer("SR234"))
    val bike1 = new Bike("GOF45T", bikeCustomer)
    val bike2 = new Bike("GO5L0W", bikeCustomer)

    val vehicleMap = scala.collection.mutable.Map(car1.registration -> car1, car2.registration -> car2, bike1.registration -> bike1, bike2.registration -> bike2)

    val garage = new Garage
    garage.vehicles = vehicleMap
    garage.getContents()
    garage.removeVehiclesByType(new Bike("DONE123", new Customer("CUL8R")))
    garage.removeVehicle(car1)
    //garage.vehicles.foreach(x=>println(x))
    println("removing all bikes and one car")
    garage.getContents()


  }

}
