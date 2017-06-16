import java.util

import scala.collection.mutable

val file = "C:\\Users\\Administrator\\IdeaProjects\\newProject\\src\\anagrams.txt"
val lines = scala.io.Source.fromFile(file).getLines().toList.sortWith(_<_)

val hashMap: mutable.HashMap[String, util.ArrayList[String]]
//print(text)
for (word: String <- lines) {
  println(s"$word = ${sortWord(word)}")
//  hashMap += (word -> getAnagrams(word))
}

def sortWord(word: String): String = {
  word.trim.toLowerCase.sortWith(_<_)
}

//def getAnagrams(word: String): util.ArrayList[String] = {
////  lines.map
//}


// tea eat feast