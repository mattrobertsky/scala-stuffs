

val coderMap = Map(
  // Letters
  ".-"->'A', "-..."-> 'B', "-.-."-> 'C', "-.."-> 'D', "."-> 'E',
  "..-."-> 'F', "--."-> 'G', "...."-> 'H', ".."-> 'I', ".---"-> 'J',
  "-.-" -> 'K', ".-.."-> 'L', "--"-> 'M', "-."-> 'N', "---"-> 'O',
  ".--."-> 'P', "--.-"-> 'Q', ".-."-> 'R', "..." -> 'S', "-" -> 'T',
  "..-" -> 'U', "...-"-> 'V', ".--"-> 'W', "-..-"-> 'X', "-.--"-> 'Y',
  "--.."-> 'Z', "/" -> " "
)

val morse = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.—"

def decodeMorse(morse: String) = {
  morse.split(" ").flatMap(item => coderMap.get(item)).mkString
}

decodeMorse(morse)

