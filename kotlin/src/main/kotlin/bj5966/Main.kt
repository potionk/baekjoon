package bj5966

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val (k, line) = br.readLine().split(" ")
        val lineArray = line.toCharArray()
        val stack = Stack<Char>()
        lineArray.forEach {
            if (it == '>') {
                stack.push(it)
            } else {
                if (stack.isEmpty()) {
                    stack.push(it)
                } else {
                    if (stack.peek() == '>') {
                        stack.pop()
                    } else {
                        stack.push(it)
                    }
                }
            }
        }
        bw.write(if (stack.isEmpty()) "legal\n" else "illegal\n")
    }
    br.close()
    bw.close()
}
