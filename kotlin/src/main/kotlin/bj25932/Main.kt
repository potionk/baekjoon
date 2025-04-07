package bj25932

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val str = br.readLine()
        val list = str.split(" ").map { it.toInt() }
        println(str)
        val exist17 = list.contains(17)
        val exist18 = list.contains(18)
        if(exist17 && exist18) {
            println("both")
        } else if (exist17) {
            println("zack")
        } else if (exist18) {
            println("mack")
        } else {
            println("none")
        }
        println()
    }
}
