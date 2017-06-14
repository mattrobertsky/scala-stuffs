class Goldilocks(w: Int, m: Int) {
  val weight = w
  val maxFoodTemp = m
}

class PlaceAtTable(mw: Int, tmp: Int) {
  val chairMaxWeight = mw
  val tmpOfFood = tmp
}

import scala.collection.mutable.ListBuffer
import scala.io.Source
val listOfPlaces: ListBuffer[PlaceAtTable] = ListBuffer()
val file = "C:\\Users\\Administrator\\IdeaProjects\\newProject\\src\\source.txt"

for (line <- Source.fromFile(file).getLines) {
  val cw = line.split(" ")(0).toInt
  val tmp = line.split(" ")(1).toInt
  listOfPlaces += new PlaceAtTable(cw, tmp)
}

def tellGoldilocksWhereSheCouldSit(goldilocks: Goldilocks, places: List[PlaceAtTable]): Unit = {
  places.filter(x => (x.chairMaxWeight > goldilocks.weight && x.tmpOfFood < goldilocks.maxFoodTemp )).foreach(p => println(s"Seat ${places.indexOf(p)} is okay for goldilocks\n"))
}

tellGoldilocksWhereSheCouldSit(new Goldilocks(100,120), listOfPlaces.toList)