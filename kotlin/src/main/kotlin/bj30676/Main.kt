package bj30676

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val lambda = br.readLine().toInt()
    println(
        when (lambda) {
            in 620 .. 780 -> {
                "Red"
            }
            in 590 .. 619 -> {
                "Orange"
            }
            in 570 .. 589 -> {
                "Yellow"
            }
            in 495 .. 569 -> {
                "Green"
            }
            in 450 .. 494 -> {
                "Blue"
            }
            in 425 .. 449 -> {
                "Indigo"
            }
            in 380 .. 424 -> {
                "Violet"
            }
            else -> {
                "Invisible"
            }
        }
    )
}
