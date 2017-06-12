  package Garages

  import scala.collection.mutable

  /**
    * Created by Administrator on 12/06/2017.
    */
  class Garage {

    var employees = scala.collection.mutable.Map[String, Employee]()
    var customers = scala.collection.mutable.Map[String, Customer]()
    var vehicles = scala.collection.mutable.Map[String, Vehicle]()
    var open: Boolean = true

    def openGarage(): Unit = {
      open = true
    }

    def closeGarage(): Unit = {
      open = false
    }

    def addEmployee(employee: Employee): Unit = {
      employees += (employee.id -> employee)
    }

    def removeEmployee(employee: Employee): Unit = {
      employees -= (employee.id)
    }

    def addVehicle(vehicle: Vehicle): Unit = {
      vehicles += (vehicle.registration -> vehicle)
    }

    def removeVehicle(vehicle: Vehicle): Unit = {
      vehicles -= (vehicle.registration)
    }

    def removeVehiclesByType(c: Vehicle): Unit = {
      vehicles.retain((k, v) => v.getClass() != c.getClass())
    }

    def fixVehicle(vehicle: Vehicle): Unit = {
      vehicle.working = true
    }

    def getContents(): Unit = {
      println("Garage contents: ")
      vehicles.values.foreach(item  => println("  "+item.toString))
    }

  }
