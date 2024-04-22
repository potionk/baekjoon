package bj1673

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var line: String?
    while (true) {
        line = br.readLine()
        if (line == null) {
            break
        }
        val (n, k) = line.split(" ").map { it.toInt() }
        println(calculateCount(n, k))
    }
}

fun calculateCount(n: Int, k: Int): Int {
    var count = n
    var stamp = n
    while (stamp >= k) {
        val newStamp = stamp / k
        count += newStamp
        stamp = newStamp + stamp % k
    }
    return count
}
