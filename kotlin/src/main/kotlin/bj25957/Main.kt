package bj25957

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val str = br.readLine()
        val sortedWord = if (str.length == 1) str else
            str[0] + str.substring(1, str.length - 1).toCharArray().sorted().joinToString("") + str[str.length - 1]
        map[sortedWord] = str
    }
    val m = br.readLine().toInt()
    println(
        br.readLine()
            .split(" ")
            .map {
                if (it.length == 1) return@map map[it]
                map[it[0] + it.substring(1, it.length - 1).toCharArray().sorted().joinToString("") + it[it.length - 1]]
            }
            .joinToString(" ")
    )
}
