package bj31822

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val code = br.readLine().substring(0, 5)
    val n = br.readLine().toInt()
    var count = 0
    repeat(n) {
        if (br.readLine().startsWith(code)) {
            count++
        }
    }
    println(count)
}
