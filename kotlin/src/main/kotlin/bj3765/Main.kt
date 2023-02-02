package bj3765

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var readLine = br.readLine()
    while (readLine != null) {
        bw.write("$readLine\n")
        readLine = br.readLine()
    }
    br.close()
    bw.close()
}
