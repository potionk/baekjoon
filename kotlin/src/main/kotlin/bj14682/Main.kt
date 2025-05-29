package bj14682

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val k = br.readLine().toInt()
    var result = n
    repeat(k) {
        n *= 10
        result += n
    }
    println(result)
}
