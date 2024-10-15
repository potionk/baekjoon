package bj6513

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l, n) = br.readLine().split(" ").map { it.toInt() }
    val dictionary = mutableMapOf<String, String>()
    repeat(l) {
        val (a, b) = br.readLine().split(" ")
        dictionary[a] = b
    }
    repeat(n) {
        val word = br.readLine()
        println(toPlural(dictionary, word))
    }
}

fun toPlural(dictionary: Map<String, String>, word: String): String {
    if (dictionary.containsKey(word)) return dictionary[word]!!
    if (word.endsWith("y") && (word.length >= 2 && !isVowel(word[word.length - 2]))) return word.dropLast(1) + "ies"
    if (word.endsWith("o") || word.endsWith("s") || word.endsWith("sh") || word.endsWith("ch") || word.endsWith("x")) return word + "es"
    return word + "s"
}

fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

