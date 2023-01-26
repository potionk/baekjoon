package bj23841

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nm = br.readLine().split(" ").map { it.toInt() }
    val n = nm[0]
    val m = nm[1]
    val painting = Array(n) { CharArray(m) }
    for (i in 0 until n) {
        val readLine = br.readLine().toCharArray()
        painting[i].fill(' ')
        for (j in 0 until m) {
            if (painting[i][j] == ' ') {
                if (readLine[j] != '.') {
                    painting[i][j] = readLine[j]
                    painting[i][m - j - 1] = readLine[j]
                } else {
                    painting[i][j] = '.'
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            bw.write("${painting[i][j]}")
        }
        bw.write("\n")
    }

    br.close()
    bw.close()
}
