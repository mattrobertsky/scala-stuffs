  package Garages

  import scala.Option.option2Iterable
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
    var fixedVehicleQueue: Queue[Vehicle] = new Queue[Vehicle]()
    //var employeeVehicleQueue: Queue[Vehicle] = new mutable.Queue[Vehicle]()

    var vehicleMap: Map[String, Vehicle] = Map[String, Vehicle]()
//    var employeeVehicleMap: Map[String, ListBuffer[Vehicle]] = Map[String, ListBuffer[Vehicle]]().withDefaultValue(new ListBuffer[Vehicle])
    var employeeVehicleMap: Map[String, Queue[Vehicle]] = Map[String, Queue[Vehicle]]().empty

    var open: Boolean = false
    val workingHours: Double = 8
    val labourRate: Double = 5

    def openGarage(): Unit = {
      open = true
      queueVehicles()
      assignWork()
    }

    private def assignWork(): Unit = {
      for (employee:Employee <- employees.values) {
        var hours = workingHours
        //var vehicles = vehicleMap.values
        for (vehicle: Vehicle <- employeeVehicleMap(employee.id)) hours -= vehicle.getHoursToFix()
        while (employee.bookedHours <= workingHours) {
          //var vehicle = vehicles.head
          println(s"is the q empty?? ${vehicleQueue.isEmpty}")
          val vehicle = vehicleQueue.dequeue()
          employee.bookedHours += vehicle.getHoursToFix()
          println(s"employee.bookedHours for ${employee.id} is ${employee.bookedHours}")
          if (employeeVehicleMap.contains(employee.id)) {
            employeeVehicleMap(employee.id) += vehicle
          } else {
            var lb = new Queue[Vehicle]
            lb += vehicle
            employeeVehicleMap += (employee.id -> lb)
          }
          removeVehicle(vehicle) // TODO we have some duplication try to remove the original vehicle map
        }
      }
    }

    // look at queue
    private def queueVehicles(): Unit = {
      var capacity = getDailyCapacity
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
      println(s"now capacity is $capacity")
    }

    private def getDailyCapacity:Double = {
      // this is a hack, our queue ran out so now we always queue 2 days worth of work
      (workingHours*2) * employees.values.size
    }

    def closeGarage(): Unit = {
      open = false
      fixVehicles()


    }

    def fixVehicles(): Unit = {
      // for each employee get their work queue
      for (employee: Employee <- employees.values) {
        val q: Queue[Vehicle] = employeeVehicleMap(employee.id)
        // while there are hours in the day process the q
        var hours = workingHours
        while (hours > 0) {
          val vehicle: Vehicle = q.front
          if (vehicle.getHoursToFix() < hours) {
            hours -= vehicle.getHoursToFix()
            fixVehicle(vehicle)
            q.dequeue()
          } else {
            vehicle.workDone = hours
            hours -= hours
          }
        }
      }
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
      println(s"vehicle in fixvehicle is $vehicle")
      vehicle.working = true
      fixedVehicleQueue += vehicle
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
