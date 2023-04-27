package bj24267

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    print("${(n * (n - 1) * (n - 2)) / 6}\n3")
    br.close()
}
