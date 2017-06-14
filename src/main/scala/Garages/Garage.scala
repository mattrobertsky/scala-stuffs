  package Garages

  import scala.collection.mutable
  import scala.collection.mutable.Map
  import scala.collection.mutable.ListBuffer
  import scala.collection.mutable.Queue
  import scala.util.Random

  /**
    * Created by Administrator on 12/06/2017.
    */
  class Garage(employees: scala.collection.mutable.Map[String, Employee]) {

    //var employees = scala.collection.mutable.Map[String, Employee]()
    //var customers = scala.collection.mutable.Map[String, Customer]()
    // TODO vehicleMap could maybe be a queue, there probably isn't a requirement to get by registration
    var vehicleQueue: Queue[Vehicle] = new Queue[Vehicle]()
    var employeeVehicleQueue: Queue[Vehicle] = new mutable.Queue[Vehicle]()

    var vehicleMap: Map[String, Vehicle] = Map[String, Vehicle]()
    var employeeVehicleMap: Map[String, ListBuffer[Vehicle]] = Map[String, ListBuffer[Vehicle]]()

    var open: Boolean = false
    val workingHours: Double = 8


    def openGarage(): Unit = {
      open = true
      queueVehicles()
      //assignWork()
    }

    private def assignWork(): Unit = {
      for (employee:Employee <- employees.values) {
        var hours = workingHours
        var vehicles = vehicleMap.values
        for (vehicle: Vehicle <- employeeVehicleMap(employee.id)) hours -= vehicle.getHoursToFix()
        while (employee.bookedHours < workingHours) {
          //var vehicle = vehicles.head
          var vehicle = vehicleQueue.dequeue()
          employee.bookedHours += vehicle.getHoursToFix()
          if (employeeVehicleMap.contains(employee.id)) {
            employeeVehicleMap(employee.id) += vehicle
          } else {
            var lb = new ListBuffer[Vehicle]
            lb += vehicle
            employeeVehicleMap += (employee.id -> lb)
          }
          removeVehicle(vehicle)
        }
      }
    }

    // look at queue
    private def queueVehicles(): Unit = {
      var capacity = getDailyCapacity
      println(s"capacity is $capacity")
      // check vehicles already in the garage
      for (vehicle: Vehicle <- vehicleMap.values) capacity -= vehicle.getHoursToFix()
      // add vehicles until we have used all of our capacity
      while (capacity > 0) {
        val vehicle = Vehicle.BrokenVehicleQueue.next()
        vehicle.breakParts()
        addVehicle(vehicle)
        vehicleQueue.+=:(vehicle)
        capacity -= vehicle.getHoursToFix()
      }
    }

    private def getDailyCapacity:Double = {
      workingHours * employees.values.size
    }

    def closeGarage(): Unit = {


//      for (vehicle: Vehicle <- vehicles.values) {}
      open = false
    }

    def addEmployee(employee: Employee): Unit = {
      employees += (employee.id -> employee)
    }

    def removeEmployee(employee: Employee): Unit = {
      employees -= employee.id
    }

    def addVehicle(vehicle: Vehicle): Unit = {
      vehicleMap += (vehicle.registration -> vehicle)
    }

    def removeVehicle(vehicle: Vehicle): Unit = {
      vehicleMap -= vehicle.registration
    }

    def removeVehiclesByType(c: Vehicle): Unit = {
      vehicleMap.retain((k, v) => v.getClass != c.getClass)
    }

    def fixVehicle(vehicle: Vehicle): Unit = {
      vehicle.working = true
    }

    def getContents(): Unit = { // TODO change the return type to String
      println("Garage queue: ")
      vehicleMap.values.foreach(item  => println(s"  ${item.toString} hours to fix: ${item.getHoursToFix()}"))

      for (employeeId:String <- employeeVehicleMap.keys) {
        println(s"Assigned to $employeeId:")
        employeeVehicleMap(employeeId).toList.foreach(item => println(s"  ${item.toString} hours to fix: ${item.getHoursToFix()}"))
      }
    }


  }
