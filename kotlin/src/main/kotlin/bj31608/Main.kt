package bj31608

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val t = br.readLine()
    var count = 0
    for (i in 0 until n) {
        if (s[i] != t[i]) {
            count++
        }
    }
    println(count)
}
