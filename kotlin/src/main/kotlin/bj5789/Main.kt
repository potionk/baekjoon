package bj5789

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val s = br.readLine()
        if (s[s.length / 2 - 1] == s[s.length / 2]) {
            bw.write("Do-it\n")
        } else {
            bw.write("Do-it-Not\n")
        }
    }
    br.close()
    bw.close()
}
