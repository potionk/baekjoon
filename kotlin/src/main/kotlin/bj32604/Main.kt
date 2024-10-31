package bj32604

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var a = 0
    var b = 0
    repeat(n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        if (a > x) {
            println("no")
            return
        }
        if (b > y) {
            println("no")
            return
        }
        a = x
        b = y
    }
    println("yes")
}
