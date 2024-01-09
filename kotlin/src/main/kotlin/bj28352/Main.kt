package bj28352

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    println(if (n == 10L) 6 else 6 * (11..n).reduce { t, i -> t * i })
}
