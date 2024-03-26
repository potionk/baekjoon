package bj8975

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val words = mutableSetOf<String>()
    repeat(n) {
        words.add(br.readLine())
    }
    val m = br.readLine().toInt()
    val checkSet = mutableSetOf<String>()
    for (i in 0 until m) {
        val word = br.readLine()
        if (words.contains(word)) {
            checkSet.add(word)
        }
        if (checkSet.size * 2 >= n) {
            println(i + 1)
            break
        }
    }
}
