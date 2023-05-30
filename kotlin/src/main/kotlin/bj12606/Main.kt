package bj12606

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val words = br.readLine().split(" ")
        bw.write("Case #$i: ")
        for (j in words.size - 1 downTo 0) {
            bw.write("${words[j]} ")
        }
        bw.write("\n")
    }
    br.close()
    bw.close()
}
