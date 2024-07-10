package bj5292

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    for (i in 1..n) {
        if (i % 5 == 0 && i % 3 == 0) {
            println("DeadMan")
        } else if (i % 5 == 0) {
            println("Man")
        } else if (i % 3 == 0) {
            println("Dead")
        } else {
            print("$i ")
        }
    }
}
