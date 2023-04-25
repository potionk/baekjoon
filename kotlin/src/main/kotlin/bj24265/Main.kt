package bj24265

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    if (n == 0L) {
        print("0\n0")
        return
    } else {
        print("${(n * (n - 1) / 2)}\n2")
    }
    br.close()
}
