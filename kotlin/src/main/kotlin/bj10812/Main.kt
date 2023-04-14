package bj10812

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(n) { it + 1 }
    for (a in 0 until m) {
        val (i, j, k) = br.readLine().split(" ").map { it.toInt() }
        val temp = array.copyOfRange(i - 1, j)
        for (b in 0 until j - i + 1) {
            array[i - 1 + b] = temp[(k - i + b) % (j - i + 1)]
        }
    }
    for (i in 0 until n) {
        bw.write("${array[i]} ")
    }
    br.close()
    bw.close()
}
