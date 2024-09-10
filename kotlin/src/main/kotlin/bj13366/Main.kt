package bj13366

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val xStr = br.readLine()
        var x = 0L
        xStr.forEach { x += it - '0' }
        println(
            if (x % 9 == 0L) {
                "YES"
            } else {
                "NO"
            }
        )
    }
}
