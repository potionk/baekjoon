package bj27890

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, n) = br.readLine().split(" ").map { it.toInt() }
    var xT = x
    for (i in 0 until n) {
        xT = if (xT % 2 == 0) {
            xT / 2 xor 6
        } else {
            2 * xT xor 6
        }
    }
    println(xT)
}
