package bj29934

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val set = mutableSetOf<String>()
    for (i in 0 until n) {
        set.add(br.readLine())
    }
    val m = br.readLine().toInt()
    var count = 0
    for (i in 0 until m) {
        if (set.contains(br.readLine())) {
            count++
        }
    }
    println(count)
}
