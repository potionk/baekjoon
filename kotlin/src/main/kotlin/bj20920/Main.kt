package bj20920

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val words = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val word = br.readLine()
        if (word.length >= m) {
            words[word] = words.getOrDefault(word, 0) + 1
        }
    }
    val sortedWords = words.toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }
            .thenBy { -it.first.length }
            .thenBy { it.first })
    for (word in sortedWords) {
        bw.write("${word.first}\n")
    }
    br.close()
    bw.close()
}
