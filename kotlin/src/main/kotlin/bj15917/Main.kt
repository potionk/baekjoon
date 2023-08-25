package bj15917

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val q = br.readLine().toInt()
    for (i in 1..q) {
        val a = br.readLine().toInt()
        if (a and (a - 1) == 0) {
            bw.write("1\n")
        } else {
            bw.write("0\n")
        }
    }
    bw.close()
}
