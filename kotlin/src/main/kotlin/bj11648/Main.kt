package bj11648

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toCharArray()
    var count = 0
    while (true) {
        if (n.size == 1) {
            break
        }
        var result = 1
        for (i in n) {
            result *= i.toString().toInt()
        }
        n = result.toString().toCharArray()
        count++
    }
    println(count)
}
