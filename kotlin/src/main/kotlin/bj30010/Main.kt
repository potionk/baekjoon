package bj30010

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    bw.write("$n ")
    (1 until n).forEach {
        bw.write("$it ")
    }
    bw.flush()
}