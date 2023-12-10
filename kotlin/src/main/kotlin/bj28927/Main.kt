package bj28927

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (t1, e1, f1) = br.readLine().split(" ").map { it.toInt() }
    val (t2, e2, f2) = br.readLine().split(" ").map { it.toInt() }
    val aTotal = t1 * 3 + e1 * 20 + f1 * 120
    val bTotal = t2 * 3 + e2 * 20 + f2 * 120
    if(aTotal > bTotal) {
        println("Max")
    } else if(aTotal < bTotal) {
        println("Mel")
    } else {
        println("Draw")
    }
}
