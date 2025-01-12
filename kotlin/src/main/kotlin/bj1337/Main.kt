package bj1337

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(n) { br.readLine().toInt() }.sorted()
    var min = 4
    for (i in 0 until n) {
        var count = 1
        for (j in i + 1 until n) {
            if (arr[j] - arr[i] < 5) {
                count++
            }
        }
        min = min(min, 5 - count)
    }
    println(min)
}
