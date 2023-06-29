package bj24736

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 0 until 2) {
        val (a, b, c, d, e) = br.readLine().split(" ").map { it.toInt() }
        print("${a * 6 + b * 3 + c * 2 + d + e * 2} ")
    }
    br.close()
}
