package bj13280

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        val list = br.readLine().split(" ").map { it.toInt() }.sorted()
        var min = Int.MAX_VALUE
        for (i in 0 until n - 1) {
            min = min(min, list[i + 1] - list[i])
        }
        println(min)
    }
}
