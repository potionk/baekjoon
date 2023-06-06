package bj10480

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val a = br.readLine().toInt()
        if (a % 2 == 0) {
            bw.write("$a is even\n")
        } else {
            bw.write("$a is odd\n")
        }
    }
    br.close()
    bw.close()
}
