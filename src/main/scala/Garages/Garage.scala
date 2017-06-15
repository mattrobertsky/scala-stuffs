  package Garages

  import scala.collection.mutable.{Map, Queue}
  import java.util.Calendar
  import java.util.NoSuchElementException


  /**
    * Created by Administrator on 12/06/2017.
    */
  class Garage(employees: scala.collection.mutable.Map[String, Employee]) {

    var vehicleQueue: Queue[Vehicle] = new Queue[Vehicle]()


    var employeeVehicleMap: Map[String, Queue[Vehicle]] = Map[String, Queue[Vehicle]]().empty

    var open: Boolean = false
    val workingHours: Double = 8
    val labourRate: Double = 25
    var openingDay: Int = 0
    val openingHour: Int = 8



    val fistDay: java.util.Date = Calendar.getInstance.getTime

    private def getTime(hour: Int, minute: Int): java.util.Date = {
      val cal: Calendar = Calendar.getInstance()
      cal.set(Calendar.HOUR_OF_DAY, hour + openingHour)
      cal.set(Calendar.MINUTE, minute)
      cal.set(Calendar.SECOND, 0)
      cal.add(Calendar.DAY_OF_YEAR, openingDay)
      cal.getTime
    }

    def openGarage(): Unit = {
      open = true
      queueVehicles()
      assignWork()
    }

    // takes vehicles off the garage queue and gives them to an employee assuming they have enough hours free
    private def assignWork(): Unit = {
      for (employee:Employee <- employees.values) {
        var hours = workingHours
        // there probably is a better way to do this
        try {
          for (vehicle: Vehicle <- employeeVehicleMap(employee.id)) hours -= vehicle.getHoursToFix
        } catch {
          // happens.. the employee is yet to have any work
          case e: NoSuchElementException => //println("not a problem..")
        }
        while (employee.bookedHours <= workingHours) {
          val vehicle = vehicleQueue.dequeue()
          employee.bookedHours += vehicle.getHoursToFix
          if (employeeVehicleMap.contains(employee.id)) {
            employeeVehicleMap(employee.id) += vehicle
          } else {
            var q  = new Queue[Vehicle]
            q += vehicle
            employeeVehicleMap += (employee.id -> q)
          }
        }
      }
    }

    // puts vehicles into a work queue for the garage
    private def queueVehicles(): Unit = {
      var capacity = getDailyCapacity
      while (capacity > 0) {
        val vehicle = Vehicle.BrokenVehicleFactory.next()
        vehicle.breakParts()
        vehicleQueue.+=:(vehicle)
        capacity -= vehicle.getHoursToFix
      }
    }

    private def getDailyCapacity:Double = {
      // this is a hack, our queue ran out so now we always queue 2 days worth of work
      (workingHours*2) * employees.values.size
    }

    def closeGarage(): Unit = {
      open = false
      openingDay += 1
      fixVehicles()
    }


    // TODO split this out into smaller functions
    private def fixVehicles(): Unit = {
      // for each employee get their work queue
      var dayTotal: Double = 0
      for (employee: Employee <- employees.values) {
        val q: Queue[Vehicle] = employeeVehicleMap(employee.id)
        // while there are hours in the day process the q
        var hours = workingHours
        while (hours > 0 && q.size > 0) {
          val vehicle: Vehicle = q.front
          if (vehicle.getHoursToFix <= hours) {
            hours -= vehicle.getHoursToFix
            fixVehicle(vehicle)
            employee.bookedHours -= vehicle.getHoursToFix
            val fixTime = this.getTime((workingHours - hours.ceil).toInt, (((workingHours - hours) * 60) % 60).toInt)
            val partsTotal = vehicle.getCostOfPartsToFix
            val labourTotal = labourCost(vehicle.getHoursToFix)
            val total = partsTotal + labourTotal
            dayTotal += total
            println(s"\n============================================================================================================================\n" +
              s"$fixTime -- ${employee.id} fixed $vehicle" +
              s"Parts total: $partsTotal \nLabour total: ${vehicle.getHoursToFix} hours @ £${this.labourRate} = £$labourTotal" +
              s"\nTotal = £$total" +
              s"\n============================================================================================================================\n")
            q.dequeue()
          } else {
            vehicle.workDone += hours
            employee.bookedHours -= hours
            println(s"\n *************************************************************************************************************************\n" +
              s"${employee.id} has done $hours hours work on $vehicle\n" +
              s"${vehicle.getHoursToFix} hours work left to do.\n" +
              s"**************************************************************************************************************************\n")
            hours -= hours

          }
        }
      }
      println("\n#############################################################################################################################\n" +
        s"Day Total: $dayTotal" +
        s"\n#############################################################################################################################\n")

    }

    private def labourCost(hours: Double): Double = {
      hours * labourRate
    }

    def addEmployee(employee: Employee): Unit = {
      if (!this.open)  throw new RuntimeException("can't add employees while the garage is open dude!")
      employees += (employee.id -> employee)
    }

    def removeEmployee(employee: Employee): Unit = {
      employees -= employee.id
      reassignWork(employee)
    }

    private def reassignWork(employee: Employee): Unit = {
      vehicleQueue ++= employeeVehicleMap(employee.id)
    }

    // TODO these became redundant when I removed the original map, I should probably reimplement and then tidy
//    def addVehicle(vehicle: Vehicle): Unit = {
//      vehicleMap += (vehicle.registration -> vehicle)
//    }
//
//    def removeVehicle(vehicle: Vehicle): Unit = {
//      vehicleMap -= vehicle.registration
//    }
//
//    def removeVehiclesByType(c: Vehicle): Unit = {
//      vehicleMap.retain((k, v) => v.getClass != c.getClass)
//    }

    // TODO check if this has beceom redundant
    private def fixVehicle(vehicle: Vehicle): Unit = {
      vehicle.working = true
    }

    def getContents(): Unit = { // TODO change the return type to String
      for (employeeId:String <- employeeVehicleMap.keys) {
        println(s"Assigned to $employeeId:")
        employeeVehicleMap(employeeId).toList.foreach(item => println(s"  ${item.toString} hours to fix: ${item.getHoursToFix}"))
      }
    }
  }
