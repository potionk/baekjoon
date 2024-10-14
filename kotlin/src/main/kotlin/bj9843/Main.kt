package bj9843

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var register = 0
    val stack = LinkedList<Int>()
    val commands = List(n) { br.readLine().split(" ") }
    var idx = 0
    while (idx < n) {
        val command = commands[idx]
        when (command[0]) {
            "PUSH" -> stack.push(command[1].toInt())
            "STORE" -> register = stack.pop()
            "LOAD" -> stack.push(register)
            "PLUS" -> {
                stack.push(stack.pop() + stack.pop())
            }

            "TIMES" -> {
                stack.push(stack.pop() * stack.pop())
            }

            "IFZERO" -> {
                if (stack.pop() == 0) {
                    idx = command[1].toInt() - 1
                }
            }

            "DONE" -> {
                println(stack.pop())
                return
            }
        }
        idx++
    }
}
