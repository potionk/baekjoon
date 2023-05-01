package bj5357

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val str = br.readLine().toCharArray()
        val result = StringBuilder()
        var before = str[0]
        for (j in 1 until str.size) {
            if (str[j] != before) {
                result.append(before)
                before = str[j]
            }
        }
        bw.write("${result.append(before)}\n")
    }
    br.close()
    bw.close()
}
