package bj5341

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        var result = 0
        for (i in 1..n) {
            result += i
        }
        bw.write("$result\n")
    }
    br.close()
    bw.close()
}
