package bj24266

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    print("${n * n * n}\n3")
    br.close()
}
