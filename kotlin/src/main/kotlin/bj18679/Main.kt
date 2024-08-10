package bj18679

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" = ")
        map[a] = b
    }
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val wordNum = br.readLine().toInt()
        val words = br.readLine().split(" ")
        println(words.joinToString(" ") { map[it]!! })
    }
}
