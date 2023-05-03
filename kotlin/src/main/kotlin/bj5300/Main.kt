package bj5300

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    var count = 0
    for (i in 1..n) {
        bw.write("$i ")
        count++
        if (count % 6 == 0) {
            bw.write("Go! ")
        }
    }
    if (n % 6 != 0) {
        bw.write("Go!")
    }
    br.close()
    bw.close()
}
