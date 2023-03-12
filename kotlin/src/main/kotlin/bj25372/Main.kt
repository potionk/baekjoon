package bj25372

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        if (br.readLine().length in 6..9) {
            bw.write("yes\n")
        } else {
            bw.write("no\n")
        }
    }
    br.close()
    bw.close()
}
