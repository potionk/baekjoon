package bj12756

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (aAtt, aHp) = br.readLine().split(" ").map { it.toInt() }
    var (bAtt, bHp) = br.readLine().split(" ").map { it.toInt() }
    while (aHp > 0 && bHp > 0) {
        aHp -= bAtt
        bHp -= aAtt
    }
    println(
        when {
            aHp <= 0 && bHp <= 0 -> "DRAW"
            aHp <= 0 -> "PLAYER B"
            else -> "PLAYER A"
        }
    )
}
