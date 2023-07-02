package bj6750

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val letter = br.readLine().toCharArray()
    var isRotatingLetter = true
    for (i in letter.indices) {
        if (!isRotatingLetter(letter[i])) {
            isRotatingLetter = false
            break
        }
    }
    if (isRotatingLetter) {
        println("YES")
    } else {
        println("NO")
    }
    br.close()
}

fun isRotatingLetter(letter: Char): Boolean {
    when (letter) {
        'I', 'O', 'S', 'H', 'Z', 'X', 'N' -> return true
    }
    return false
}
