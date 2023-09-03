package bj25600

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = 0
    for (i in 0 until n) {
        val (a, d, g) = br.readLine().split(" ").map { it.toInt() }
        val store = calStore(a, d, g)
        if (store > max) {
            max = store
        }
    }
    println(max)
}

fun calStore(a: Int, d: Int, g: Int): Int {
    return if (a == d + g) {
        2 * (a * (d + g))
    } else {
        a * (d + g)
    }
}
