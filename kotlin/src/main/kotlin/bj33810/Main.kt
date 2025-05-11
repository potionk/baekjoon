package bj33810

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val expect = "SciComLove".toCharArray()
    val str = br.readLine().toCharArray()
    var count = 0
    for (i in str.indices) {
        if (str[i] != expect[i]) {
            count++
        }
    }
    println(count)
}