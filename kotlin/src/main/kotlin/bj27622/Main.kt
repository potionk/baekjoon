package bj27622

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    val logs = br.readLine().split(" ").map { it.toInt() }
    val set = mutableSetOf<Int>()
    var errorCount = 0
    logs.forEach {
        if (it > 0) {
            set.add(it)
        } else {
            if (set.contains(-it)) {
                set.remove(-it)
            } else {
                errorCount++
            }
        }
    }
    println(errorCount)
}
