def blackjack(a: Int, b: Int): Int = (a,b) match {
  case (a, b) if a <= 21 && (a > b || b > 21) => a
  case (a, b) if b <= 21 && (b > a || a > 21) => b
  case _ => 0
}

// TODO - revisit.. would be nice to try a .map approach

blackjack(18,21)
blackjack(20, 18)
blackjack(22, 22)
blackjack(22, 21)