package bj18698

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine()
    for (i in 0 until n.toInt()) {
        val input = br.readLine()
        val dIdx = input.indexOf('D')
        if (dIdx == -1) {
            bw.write("${input.length}\n")
        } else {
            bw.write("${dIdx}\n")
        }
    }
    bw.close()
}
