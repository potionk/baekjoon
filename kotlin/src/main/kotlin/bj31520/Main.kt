package bj31520

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    var count = 1
    var idx = 0
    while (idx < str.length) {
        if (str.slice(idx until idx + count.toString().length).toInt() != count) {
            println(-1)
            return
        }
        idx += count.toString().length
        count++
    }
    println(count - 1)
}
