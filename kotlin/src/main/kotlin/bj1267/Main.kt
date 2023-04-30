package bj1267

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val time = br.readLine().split(" ").map { it.toInt() }
    var y = 0
    var m = 0
    for (i in 0 until n) {
        y += (time[i] / 30 + 1) * 10
        m += (time[i] / 60 + 1) * 15
    }
    if (y < m) {
        bw.write("Y $y")
    } else if (y > m) {
        bw.write("M $m")
    } else {
        bw.write("Y M $y")
    }
    br.close()
    bw.close()
}
