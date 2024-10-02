package bj32369

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, a, b) = br.readLine().split(" ").map { it.toInt() }
    var aOnion = 1
    var bOnion = 1
    for (i in 0 until n) {
        aOnion += a
        bOnion += b
        if (aOnion < bOnion) {
            val swapResult = swap(aOnion, bOnion)
            aOnion = swapResult.first
            bOnion = swapResult.second
        }
        if (aOnion == bOnion) {
            bOnion -= 1
        }
    }
    println("$aOnion $bOnion")
}

fun swap(a: Int, b: Int): Pair<Int, Int> {
    return Pair(b, a)
}
