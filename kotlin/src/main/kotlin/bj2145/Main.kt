package bj2145

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        var n = br.readLine().toInt()
        if (n == 0) {
            break
        }
        while (n >= 10) {
            var newN = 0
            n.toString().toCharArray().forEach { newN += it - '0' }
            n = newN
        }
        bw.write("$n\n")
    }
    br.close()
    bw.close()
}
