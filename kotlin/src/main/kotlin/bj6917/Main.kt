package bj6917

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val word = br.readLine()
        if (word == "quit!") break
        val result = if (word.length > 4 && word.endsWith("or") && word[word.length - 3] !in "aeiouy") {
            word.dropLast(2) + "our"
        } else {
            word
        }
        println(result)
    }
}