package bj26068

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        val num = br.readLine().drop(2).toInt()
        if (num <= 90) {
            count++
        }
    }
    println(count)
}
