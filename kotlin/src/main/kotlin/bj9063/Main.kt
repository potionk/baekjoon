package bj9063

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if (n == 1) {
        print(0)
    } else {
        var yMax = Integer.MIN_VALUE
        var yMin = Integer.MAX_VALUE
        var xMax = Integer.MIN_VALUE
        var xMin = Integer.MAX_VALUE
        for (i in 0 until n) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            xMax = maxOf(xMax, a)
            xMin = minOf(xMin, a)
            yMax = maxOf(yMax, b)
            yMin = minOf(yMin, b)
        }
        print("${(yMax - yMin) * (xMax - xMin)}")
    }
    br.close()
}
