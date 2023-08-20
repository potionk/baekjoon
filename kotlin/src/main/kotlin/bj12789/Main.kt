package bj12789

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val waitList = br.readLine().split(" ").map { it.toInt() }
    val wait = Stack<Int>()
    val tempWait = Stack<Int>()
    var current = 1
    var isPossible = true
    for (i in n - 1 downTo 0) {
        wait.add(waitList[i])
    }
    while (wait.isNotEmpty()) {
        if (wait.peek() == current) {
            wait.pop()
            current++
            while (tempWait.isNotEmpty() && tempWait.peek() == current) {
                tempWait.pop()
                current++
            }
        } else {
            tempWait.add(wait.pop())
        }
        if (wait.isEmpty() && tempWait.isNotEmpty()) {
            isPossible = false
            break
        }
    }
    if (isPossible) {
        println("Nice")
    } else {
        println("Sad")
    }
}
