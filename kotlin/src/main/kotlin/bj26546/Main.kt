package bj26546

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val info = br.readLine().split(" ")
        val start = info[1].toInt()
        val end = info[2].toInt()
        bw.write("${info[0].substring(0 until start)}${info[0].substring(end until info[0].length)}\n")
    }
    bw.close()
}
