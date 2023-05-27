package bj26736

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val input = br.readLine().toCharArray()
    var aCount = 0
    var bCount = 0
    input.forEach {
        if (it == 'A') {
            aCount++
        } else {
            bCount++
        }
    }
    bw.write("$aCount : $bCount\n")
    br.close()
    bw.close()
}
