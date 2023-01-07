package bj25193

import java.io.*
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val s = br.readLine()
    val chicken = s.count { it == 'C' }
    if (chicken % (n + 1) == 0) {
        print(chicken / (n - chicken))
    } else {
        print(ceil(chicken.toDouble() / (n - chicken + 1)).toInt())
    }
    br.close()
}
