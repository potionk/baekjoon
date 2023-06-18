package bj15232

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val r = br.readLine().toInt()
    val c = br.readLine().toInt()
    for (i in 0 until r) {
        bw.write("${"*".repeat(c)}\n")
    }
    bw.close()
    br.close()
}
