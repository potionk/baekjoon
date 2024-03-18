package bj27219

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    print("${"V".repeat(n / 5)}${"I".repeat(n % 5)}")
}
