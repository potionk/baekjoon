package bj26558

import java.io.*
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val shirtStack = Stack<String>()
        val pantsStack = Stack<String>()
        val socksStack = Stack<String>()
        repeat(n) {
            val str = br.readLine().split("(")
            when (str[1].split(")")[0].trim()) {
                "shirt" -> shirtStack.push(str[0].trim())
                "pants" -> pantsStack.push(str[0].trim())
                "socks" -> socksStack.push(str[0].trim())
            }
        }
        while(shirtStack.isNotEmpty() && pantsStack.isNotEmpty() && socksStack.isNotEmpty()) {
            println("${shirtStack.pop()}, ${pantsStack.pop()}, ${socksStack.pop()}")
        }
        println()
    }
}
