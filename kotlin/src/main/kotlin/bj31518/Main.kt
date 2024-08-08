package bj31518

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(3) {
        val line = br.readLine().split(" ").map { it.toInt() }
        if (!line.contains(7)) {
            println(0)
            return
        }
    }
    println(777)
}
