package bj27918

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var dScore = 0
    var pScore = 0
    repeat(n) {
        if(br.readLine() == "D") {
            dScore++
        } else {
            pScore++
        }
        if(abs(dScore - pScore) >= 2) {
            println("$dScore:$pScore")
            return
        }
    }
    println("$dScore:$pScore")
}
