package bj28074

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toCharArray().toSet()
    val mobis = listOf('M', 'O', 'B', 'I', 'S')
    mobis.forEach {
        if (!input.contains(it)) {
            println("NO")
            return
        }
    }
    println("YES")
}
