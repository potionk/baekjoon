package bj2089

import java.io.*
import kotlin.math.abs
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()

    var result = ""
    if (n == 0) {
        result += "0"
    } else {
        while (n != 1) {
            result += abs(n % -2)
            n = ceil(n.toDouble() / -2).toInt()
        }
        result += n
    }
    println(result.reversed())
}
