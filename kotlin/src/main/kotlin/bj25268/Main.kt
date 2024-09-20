package bj25268

import java.io.*

val vowels = setOf('a', 'e', 'i', 'o', 'u')
val consonants = ('a'..'z').filter { it !in vowels }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val visited = mutableSetOf<String>()

    repeat(n) {
        while (true) {
            val word = createRandomWord()
            if (word !in visited) {
                visited.add(word)
                println(word)
                break
            }
        }
    }
}

fun createRandomWord(): String {
    val wordLengh = (3..20).random()
    var word = ""
    for (i in 0 until wordLengh) {
        word += if (i % 2 == 0) {
            vowels.random()
        } else {
            consonants.random()
        }
    }
    return word
}
