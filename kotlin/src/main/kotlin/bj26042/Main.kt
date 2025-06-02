package bj26042

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val queue = LinkedList<Int>()
    var maxStudentSize = 0
    var lastStudent = -1
    for (i in 0 until n) {
        val read = br.readLine().split(" ")
        if (read.size == 2) {
            queue.add(read[1].toInt())
            if (queue.size > maxStudentSize) {
                maxStudentSize = queue.size
                lastStudent = queue.peekLast()
            } else if (queue.size == maxStudentSize) {
                if (lastStudent > queue.peekLast()) {
                    lastStudent = queue.peekLast()
                }
            }
        } else {
            queue.pollFirst()
        }
    }
    println("$maxStudentSize $lastStudent")
}