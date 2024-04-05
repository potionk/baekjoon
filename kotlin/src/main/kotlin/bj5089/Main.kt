package bj5089

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var i = 1
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        val set = mutableSetOf<String>()
        repeat(n) {
            set.add(br.readLine())
        }
        println("Week ${i++} ${set.size}")
    }
}
