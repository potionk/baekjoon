package bj26552

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        var k = br.readLine().toInt() + 1
        while (true) {
            if (k.toString().contains("0")) {
                k++
            } else {
                println(k)
                break
            }
        }
    }
}
