package bj2083

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    while (true) {
        val readLine = br.readLine()
        if (readLine == "# 0 0") {
            break
        }
        val studentInfo = readLine.split(" ")
        if (studentInfo[1].toInt() > 17 || studentInfo[2].toInt() >= 80) {
            bw.write("${studentInfo[0]} Senior\n")
        } else {
            bw.write("${studentInfo[0]} Junior\n")
        }
    }
    br.close()
    bw.close()
}
