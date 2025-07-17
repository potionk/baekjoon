package bj32860

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val suffix = when {
        m in 1..26 -> ('A' + (m - 1)).toString()
        else -> {
            val offset = m - 27
            val first = 'a' + (offset / 26)
            val second = 'a' + (offset % 26)
            "$first$second"
        }
    }
    println("SN ${n}$suffix")
}
