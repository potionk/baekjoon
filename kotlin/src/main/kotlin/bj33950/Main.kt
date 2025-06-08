package bj33950

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        println(br.readLine().replace("PO", "PHO"))
    }
}
