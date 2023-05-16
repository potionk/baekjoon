package bj2975

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var readLine = br.readLine()
    while (readLine != "0 W 0") {
        val transaction = readLine.split(" ")
        val balance = transaction[0].toInt()
        val operation = transaction[1]
        val amount = transaction[2].toInt()
        if (operation == "W") {
            if (balance - amount < -200) {
                bw.write("Not allowed\n")
            } else {
                bw.write("${balance - amount}\n")
            }
        } else {
            bw.write("${balance + amount}\n")
        }
        readLine = br.readLine()
    }
    br.close()
    bw.close()
}
