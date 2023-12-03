package bj9950

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (i, w, a) = br.readLine().split(" ").map { it.toInt() }
        if (i == 0 && w == 0 && a == 0) {
            break
        }
        if (i == 0) {
            println("${(a / w)} $w $a")
        } else if (w == 0) {
            println("$i ${(a/i)} $a")
        } else {
            println("$i $w ${(i * w)}")
        }
    }
}
