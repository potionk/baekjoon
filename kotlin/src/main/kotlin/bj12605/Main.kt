package bj12605

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        bw.write("Case #$i: ${br.readLine().split(" ").reversed().joinToString(" ")}\n")
    }
    br.close()
    bw.close()
}
