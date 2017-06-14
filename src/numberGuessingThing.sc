/* this is the number guessing thing
    var upperBound = 100
    var lowerBound = 0
    def guess(input: String = "higher", lastGuess: Int = 0, previousGuess: Int = 0): Int = {
      if (input == "higher") {
        lowerBound = lastGuess
        (upperBound + lastGuess) / 2
      } else  {
        upperBound = lastGuess
        (lowerBound + lastGuess) / 2
      }
    }



    System.out.println("Think of a number 1 to 100")
    var firstGuess = math.floor(math.random()* 100).toInt
    System.out.println(s"My guess is $firstGuess" )
    var lastGuess = 0
    def getChoice: String = {
      val line = readLine()
      val g: Int = guess(line, firstGuess)
      lastGuess = firstGuess
      firstGuess = g
      line match {
        case "correct" => println(s"Bye"); line
        case "boiling" => println(s"okay, how about ${lastGuess -1}"); getChoice
        case "freezing" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case "super cold" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case "super warm" => println(s"okay, how about ${lastGuess - (lastGuess -5)}"); getChoice
        case _ => if (line == "higher" || line == "lower") println(s"how about $g"); getChoice
      }
    }
    val choiceType = getChoice
    */
