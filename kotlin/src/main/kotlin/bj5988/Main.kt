package bj5988

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val k = br.readLine().toCharArray()
        if ((k.last() - '0') % 2 == 0) {
            bw.write("even\n")
        } else {
            bw.write("odd\n")
        }
    }
    br.close()
    bw.close()
}
