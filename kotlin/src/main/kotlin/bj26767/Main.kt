package bj26767

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine()
    for (i in 1 .. n.toInt()) {
        if (i % 77 == 0) {
            bw.write("Wiwat!\n")
        } else if (i % 7 == 0) {
            bw.write("Hurra!\n")
        } else if (i % 11 == 0) {
            bw.write("Super!\n")
        } else {
            bw.write("$i\n")
        }
    }
    bw.close()
}
