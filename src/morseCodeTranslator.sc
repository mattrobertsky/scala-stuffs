

val coderMap = Map(
  // Letters
  ".-"->'A', "-..."-> 'B', "-.-."-> 'C', "-.."-> 'D', "."-> 'E',
  "..-."-> 'F', "--."-> 'G', "...."-> 'H', ".."-> 'I', ".---"-> 'J',
  "-.-" -> 'K', ".-.."-> 'L', "--"-> 'M', "-."-> 'N', "---"-> 'O',
  ".--."-> 'P', "--.-"-> 'Q', ".-."-> 'R', "..." -> 'S', "-" -> 'T',
  "..-" -> 'U', "...-"-> 'V', ".--"-> 'W', "-..-"-> 'X', "-.--"-> 'Y',
  "--.."-> 'Z'
)



val morse = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.—"

def decodeMorse(morse: String) = {
  //val code:Array[String] = morse.split(" / ").foreach(item => println(item)) // this gets the words
  val words:List[Array[String]] = morse.split(" / ").toList.map(item => item.split(" "))
  //val words:List[List[String]] = morse.split(" / ").toList.foreach()

  words.foreach(item => println(item.foreach(println))) //morse.split(" / ").map(value => value.split(" ")).foreach(item => println(item))

  //val word1 = words(0)
  //println(word1)
}

decodeMorse(morse)

coderMap.get(".-").get
