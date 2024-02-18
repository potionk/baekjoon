package bj13333

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var qIdx = 0
    for (i in n downTo 1) {
        val count = arr.count { it >= i }
        if (count >= i) {
            qIdx = i
            break
        }
    }
    println(qIdx)
}
