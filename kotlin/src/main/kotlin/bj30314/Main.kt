package bj30314

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val baseStr = br.readLine()
    val name = br.readLine()
    var result = 0
    for (i in 0 until n) {
        val diff = abs(baseStr[i] - name[i])
        result += minOf(diff, 26 - diff)
    }
    println(result)
}
