package bj20833

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0
    for (i in 1 .. n) {
        result += i * i * i
    }
    println(result)
    br.close()
}
