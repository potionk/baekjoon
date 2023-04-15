package bj9506

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val n = br.readLine().toInt()
        if (n == -1) {
            break
        }
        var total = 0
        for (i in 1 until n) {
            if (n % i == 0) {
                total += i
            }
        }
        if (total == n) {
            bw.write("$n = 1")
            for (i in 2 until n) {
                if (n % i == 0) {
                    bw.write(" + $i")
                }
            }
            bw.write("\n")
        } else {
            bw.write("$n is NOT perfect.\n")
        }
    }
    br.close()
    bw.close()
}
