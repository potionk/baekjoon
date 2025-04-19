package bj4649

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while(true) {
        val input = br.readLine().split(" ")
        if(input[0] == "0") {
            break
        }
        val n = input[0].toInt()
        val line = input[1]
        val set = mutableSetOf<Int>()
        var awayCount = 0
        line.toCharArray().forEach {
            if(set.contains(it.code)) {
                set.remove(it.code)
            } else {
                if(set.size < n) {
                    set.add(it.code)
                } else {
                    awayCount++
                }
            }
        }
        if(awayCount == 0) {
            println("All customers tanned successfully.")
        } else {
            println("${awayCount/2} customer(s) walked away.")
        }
    }
}
