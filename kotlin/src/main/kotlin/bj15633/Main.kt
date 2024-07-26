package bj15633

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var count = 0
    for (i in 1..n) {
        if (n % i == 0) {
            count += i
        }
    }
    println(count * 5 - 24)
}
