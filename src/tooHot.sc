
def tooHot(temp: Int,isSummer: Boolean): Boolean = (temp, isSummer) match {
  case (temp, isSummer) if temp >= 60 && temp <= (if(isSummer) 100 else 90) => true
  case _ => false
}

tooHot(80, false)
tooHot(100, false)
tooHot(100,true)




