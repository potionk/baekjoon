package bj2921

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0
    for (i in 0..n) {
        for (j in i..n) {
            result += i + j
        }
    }
    println(result)
    br.close()
}
