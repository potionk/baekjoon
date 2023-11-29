package bj28938

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val total = br.readLine().split(" ").sumOf { it.toInt() }
    println(if (total > 0) "Right" else if (total < 0) "Left" else "Stay")
}
