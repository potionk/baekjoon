package bj16693

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, p1) = br.readLine().split(" ").map { it.toDouble() }
    val (r, p2) = br.readLine().split(" ").map { it.toDouble() }
    println(
        if (a / p1 > r * r * Math.PI / p2) {
            "Slice of pizza"
        } else {
            "Whole pizza"
        }
    )
}
