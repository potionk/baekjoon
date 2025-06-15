package bj12595

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val g = br.readLine()
        val set = mutableSetOf<Int>()
        val list = br.readLine().split(" ").map { it.toInt() }
        list.forEach {
            if (set.contains(it)) {
                set.remove(it)
            } else {
                set.add(it)
            }
        }
        println("Case #$i: ${set.first()}")
    }
}
