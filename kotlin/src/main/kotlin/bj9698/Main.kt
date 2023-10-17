package bj9698

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1..t) {
        var (h, m) = br.readLine().split(" ").map { it.toInt() }
        m -= 45
        if (m < 0) {
            m += 60
            h -= 1
        }
        h = (h + 24) % 24
        println("Case #$i: $h $m")
    }
}
