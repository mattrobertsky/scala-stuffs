package Garages

/**
  * Created by Administrator on 13/06/2017.
  */
abstract class Part extends ToStringAble {
  val cost: Double
  val hoursToFix: Double
  var broken: Boolean = false
  def getPartType: String = {
    this.getClass.getName.replace("Garages.Part$Factory$", "")
  }
}

object Part {

  object Factory {
    private class Engine extends Part {
      override val cost: Double = 1000.00
      override val hoursToFix: Double = 5.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Brakes extends Part {
      override val cost: Double = 300.00
      override val hoursToFix: Double = 2

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Steering extends Part {
      override val cost: Double = 200.00
      override val hoursToFix: Double = 1.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Gearbox extends Part {
      override val cost: Double = 400.00
      override val hoursToFix: Double = 2.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Suspension extends Part {
      override val cost: Double = 100.00
      override val hoursToFix: Double = 1

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Radiator extends Part {
      override val cost: Double = 50.00
      override val hoursToFix: Double = 0.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Tyre extends Part {
      override val cost: Double = 25.00
      override val hoursToFix: Double = 0.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Light extends Part {
      override val cost: Double = 10.00
      override val hoursToFix: Double = 0.5

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Exhaust extends Part {
      override val cost: Double = 75.00
      override val hoursToFix: Double = 1

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }

    private class Bodywork extends Part {
      override val cost: Double = 1500.00
      override val hoursToFix: Double = 10

      override def myToString: String = s"$getPartType:: cost:$cost, broken: $broken, hours to fix: $hoursToFix"
    }


    def getParts:List[Part] = {
      List(new Bodywork, new Brakes, new Engine, new Exhaust, new Gearbox, new Light, new Radiator, new Steering, new Suspension, new Tyre)
    }

  }
}
