package bj1855

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val arr = Array(n) { CharArray(s.length/n) }
    var index = 0
    for (i in 0 until s.length/n) {
        if (i % 2 == 0) {
            for (j in 0 until n) {
                arr[j][i] = s[index++]
            }
        } else {
            for (j in n-1 downTo 0) {
                arr[j][i] = s[index++]
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until s.length/n) {
            bw.write("${arr[i][j]}")
        }
    }
    bw.close()
}
