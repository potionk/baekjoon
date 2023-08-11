package bj28278

import java.io.*
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Long>()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val input = br.readLine().split(" ")
        when (input[0]) {
            "1" -> {
                val x = input[1].toLong()
                stack.push(x)
            }

            "2" -> {
                if (stack.isNotEmpty()) {
                    bw.write("${stack.pop()}\n")
                } else {
                    bw.write("-1\n")
                }
            }

            "3" -> {
                if (stack.isNotEmpty()) {
                    bw.write("${stack.size}\n")
                } else {
                    bw.write("0\n")
                }
            }

            "4" -> {
                if (stack.isEmpty()) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }

            "5" -> {
                if (stack.isNotEmpty()) {
                    bw.write("${stack.peek()}\n")
                } else {
                    bw.write("-1\n")
                }
            }
        }
    }
    bw.close()
}
