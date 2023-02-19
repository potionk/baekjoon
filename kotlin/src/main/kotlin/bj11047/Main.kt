package bj11047

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nk = br.readLine().split(" ").map { it.toInt() }
    val n = nk[0]
    var k = nk[1]
    val coins = IntArray(n)
    for (i in 0 until n) {
        coins[i] = br.readLine().toInt()
    }
    var result = 0
    for (i in n - 1 downTo 0) {
        result += k / coins[i]
        k -= k / coins[i] * coins[i]
    }
    bw.write("$result")
    br.close()
    bw.close()
}
