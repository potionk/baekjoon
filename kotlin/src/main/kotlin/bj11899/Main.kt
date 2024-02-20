package bj11899

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    var left = 0
    var count = 0
    s.forEach {
        if (it == '(') {
            left++
        } else {
            if (left > 0) {
                left--
            } else {
                count++
            }
        }
    }
    println(count + left)
}
