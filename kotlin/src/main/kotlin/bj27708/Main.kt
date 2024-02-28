package bj27708

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    bw.write("$t\n")
    repeat(t) {
        br.readLine()
        bw.write("\n")
        val n = br.readLine().toInt()
        bw.write("$n\n")
        val list = br.readLine().split(" ").map { it.toInt() }.sorted()
        for (i in 1 until list.size) {
            bw.write("${list[i]} ")
        }
        bw.write("${list[0]}\n")
    }
    bw.close()
}
