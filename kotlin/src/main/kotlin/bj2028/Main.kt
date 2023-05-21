package bj2028

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val num = br.readLine().toInt()
        if ((num * num).toString().endsWith(num.toString())) {
            bw.write("YES\n")
        } else {
            bw.write("NO\n")
        }
    }
    br.close()
    bw.close()
}
