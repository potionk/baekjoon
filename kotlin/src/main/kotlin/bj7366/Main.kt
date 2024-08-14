package bj7366

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        br.readLine()
        val list = br.readLine().split(" ")
        val count = list.count { it == "sheep" }
        println("Case $i: This list contains $count sheep.")
        if (i != n) {
            println()
        }
    }
}
