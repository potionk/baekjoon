package bj22935

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val binaryList = mutableListOf<String>()
    for (i in 1..15) {
        binaryList.add(binaryToStrawberry(i))
    }
    for (i in 16..28) {
        binaryList.add(binaryToStrawberry(30 - i))
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(binaryList[(n - 1) % 28])
    }
}

fun binaryToStrawberry(n: Int): String {
    var binary = Integer.toBinaryString(n)
    while (binary.length < 4) {
        binary = "0$binary"
    }
    return binary.replace("0", "V").replace("1", "딸기")
}
