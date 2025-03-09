package bj32710

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<Int>()
    for (i in 1..9) {
        set.add(i)
    }
    for (i in 2..9) {
        for (j in 1..9) {
            set.add(i * j)
        }
    }
    if (set.contains(br.readLine().toInt())) {
        println("1")
    } else {
        println("0")
    }
}
