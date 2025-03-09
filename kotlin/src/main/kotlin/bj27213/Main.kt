package bj27213

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val m = br.readLine().toInt()
    val n = br.readLine().toInt()
    println(m * n - if (m - 2 > 0 && n - 2 > 0) (m - 2) * (n - 2) else 0)
}
