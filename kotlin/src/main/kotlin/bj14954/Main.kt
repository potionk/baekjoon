package bj14954

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()
    val isVisited = mutableSetOf<Int>()
    isVisited.add(n)
    while (n != 1) {
        var sum = 0
        n.toString().toCharArray().forEach {
            val i = it.toString().toInt()
            sum += i * i
        }
        n = sum
        if (isVisited.contains(n)) {
            println("UNHAPPY")
            return
        }
        isVisited.add(n)
    }
    println("HAPPY")
}
