package bj10103

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    var a = 100
    var b = 100
    for (i in 0 until n) {
        val (aScore, bScore) = br.readLine().split(" ").map { it.toInt() }
        if (aScore > bScore) {
            b -= aScore
        } else if (aScore < bScore) {
            a -= bScore
        }
    }
    bw.write("$a\n$b")
    br.close()
    bw.close()
}
