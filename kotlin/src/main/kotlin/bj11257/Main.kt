package bj11257

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var n = br.readLine().toInt()
    for (i in 0 until n) {
        val info = br.readLine().split(" ").map { it.toInt() }
        val sum = info[1] + info[2] + info[3]
        if (sum >= 55 && info[1] >= 10.5 && info[2] >= 7.5 && info[3] >= 12) {
            bw.write("${info[0]} $sum PASS\n")
        } else {
            bw.write("${info[0]} $sum FAIL\n")
        }
    }
    bw.close()
    br.close()
}
