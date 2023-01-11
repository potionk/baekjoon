package bj5717

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val readLine = br.readLine()
        if (readLine == "0 0") {
            break
        }
        val friends = readLine.split(" ")
        bw.write("${friends[0].toInt()+friends[1].toInt()}\n")
    }
    br.close()
    bw.close()
}
