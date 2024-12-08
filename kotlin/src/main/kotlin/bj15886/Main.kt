package bj15886

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine().toCharArray()
    var count = 0
    for (i in 0 until n - 1) {
        if (str[i] == 'E' && str[i + 1] == 'W') {
            count++
        }
    }
    println(count)
}
