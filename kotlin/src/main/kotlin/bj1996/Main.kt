package bj1996

import java.io.*

val ARROW = arrayOf(-1, 0, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val count = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val line = br.readLine().toCharArray()
        for (j in 0 until n) {
            if (line[j] in '0'..'9') {
                count[i][j] = -1
                for (y in ARROW.indices) {
                    for (x in ARROW.indices) {
                        if (y != 1 || x != 1) {
                            if ((i + ARROW[y]) in 0 until n && (j + ARROW[x]) in 0 until n && count[i + ARROW[y]][j + ARROW[x]] != -1) {
                                count[i + ARROW[y]][j + ARROW[x]] += line[j] - '0'
                            }
                        }
                    }
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            bw.write("${printMine(count[i][j])}")
        }
        bw.write("\n")
    }
    br.close()
    bw.close()
}

fun printMine(mine: Int): Char {
    return if (mine >= 10) {
        'M'
    } else if (mine == -1) {
        '*'
    } else {
        mine.digitToChar()
    }
}
