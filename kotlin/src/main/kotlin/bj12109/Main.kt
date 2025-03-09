package bj12109

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sortedDescending()
    var result = 0
    for (i in 0 until n) {
        if (list[i] >= i + 1) {
            result = i + 1
        } else {
            break
        }
    }
    println(result)
}
