package bj34027

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val root = sqrt(n.toDouble()).toInt()
        if (root * root == n) {
            println(1)
        } else {
            println(0)
        }
    }
}
