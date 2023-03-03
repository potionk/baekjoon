package bj7595

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        for (i in 1..n) {
            bw.write("*".repeat(i) + "\n")
        }
    }
    bw.close()
    br.close()
}
