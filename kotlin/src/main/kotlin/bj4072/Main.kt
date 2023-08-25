package bj4072

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var readLine = br.readLine()
    while (readLine != "#") {
        val words = readLine.split(" ")
        for (word in words) {
            bw.write("${word.reversed()} ")
        }
        bw.write("\n")
        readLine = br.readLine()
    }
    bw.close()
}
