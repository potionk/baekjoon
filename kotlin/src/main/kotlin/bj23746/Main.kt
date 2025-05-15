package bj23746

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val patternMap = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val (pattern, char) = br.readLine().split(" ")
        patternMap[char] = pattern
    }
    val compressed = br.readLine()
    val (s, e) = br.readLine().split(" ").map { it.toInt() }
    val decompressed = StringBuilder()
    for (char in compressed) {
        decompressed.append(patternMap[char.toString()])
    }
    println(decompressed.substring(s - 1, e))
}
