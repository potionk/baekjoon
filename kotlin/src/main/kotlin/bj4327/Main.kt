package bj4327

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val line = br.readLine() ?: break
        val (start, first, second, third) = line.split(" ").map { it.toInt() }
        if (start == 0 && first == 0 && second == 0 && third == 0) break
        var degrees = 0
        degrees += 720
        degrees += ((start - first + 40) % 40) * 9
        degrees += 360
        degrees += ((second - first + 40) % 40) * 9
        degrees += ((second - third + 40) % 40) * 9
        println(degrees)
    }
}