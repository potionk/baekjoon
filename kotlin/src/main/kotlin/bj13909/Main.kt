package bj13909

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toDouble()
    var count = 0
    var i = 1
    while (i * i <= n) {
        count++
        i++
    }
    println(count)
    br.close()
}
