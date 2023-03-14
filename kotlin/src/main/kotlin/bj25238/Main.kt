package bj25238

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val ab = br.readLine().split(" ").map { it.toDouble() }
    if (ab[0] * (100 - ab[1]) / 100 >= 100) {
        print("0")
    } else {
        print("1")
    }
    br.close()
}
