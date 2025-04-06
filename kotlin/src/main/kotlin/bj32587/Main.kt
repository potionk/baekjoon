package bj32587

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val me = br.readLine()
    val guile = br.readLine()

    var myWin = 0
    var guileWin = 0

    for (i in 0 until n) {
        when {
            me[i] == guile[i] -> continue
            me[i] == 'R' && guile[i] == 'S' ||
                    me[i] == 'S' && guile[i] == 'P' ||
                    me[i] == 'P' && guile[i] == 'R' -> myWin++

            else -> guileWin++
        }
    }

    println(if (myWin > guileWin) "victory" else "defeat")
}
