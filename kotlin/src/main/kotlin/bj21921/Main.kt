package bj21921

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val visited = br.readLine().split(" ").map { it.toInt() }
    var sum = visited.subList(0, x).sum()
    var max = sum
    var duplicatedCount = 1
    for (i in x until n) {
        sum += visited[i] - visited[i - x]
        if (sum > max) {
            max = sum
            duplicatedCount = 1
        } else if (sum == max) {
            duplicatedCount++
        }
    }
    if (max == 0) {
        println("SAD")
        return
    }
    println("$max")
    println("$duplicatedCount")
}
