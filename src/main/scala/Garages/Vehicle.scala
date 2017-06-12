package Garages

/**
  * Created by Administrator on 12/06/2017.
  */
abstract class Vehicle extends ToStringAble {

  val registration: String
  var working: Boolean
  val owner: Person

  // TODO turn Vehicle into a factory for each instance

  // TODO put parts in here
  // engine, brakes, steering, gearbox, suspension, cooling, tyres, lights, bodywork, exhaust
}
