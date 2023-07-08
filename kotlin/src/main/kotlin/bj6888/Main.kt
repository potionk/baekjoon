package bj6888

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    for (i in a..b step 60) {
        bw.write("All positions change in year $i\n")
    }
    br.close()
    bw.close()
}
