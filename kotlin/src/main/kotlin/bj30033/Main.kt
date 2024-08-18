package bj30033

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val b = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    for (i in 0 until n) {
        if (a[i] <= b[i]) {
            count++
        }
    }
    println(count)
}
