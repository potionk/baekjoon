package bj12904

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()
    var t = br.readLine()
    while (t.length > s.length) {
        t = if (t.last() == 'A') {
            t.dropLast(1)
        } else {
            t.dropLast(1).reversed()
        }
    }
    println(if (s == t) 1 else 0)
}
