package bj11094

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val line = br.readLine()
        if (line.startsWith("Simon says")) {
            println(line.removePrefix("Simon says"))
        }
    }
}