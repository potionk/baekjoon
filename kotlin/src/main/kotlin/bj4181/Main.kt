package bj4181

import java.io.*
import java.util.*

data class Point(val x: Long, val y: Long)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val points = LinkedList<Point>()
    repeat(n) {
        val (x, y, c) = br.readLine().split(" ")
        if (c == "Y") {
            points.add(Point(x.toLong(), y.toLong()))
        }
    }
    points.sortWith(compareBy({ it.x }, { it.y }))
    val p0 = points.pollFirst()
    points.sortWith { p1, p2 -> ccwCompare(p0, p2, p1) }
    points.addFirst(p0)
    convexHull(points, bw)
    bw.close()
}

fun convexHull(points: LinkedList<Point>, bw: BufferedWriter) {
    bw.write("${points.size}\n")
    val stack = Stack<Point>()
    stack.push(points.pollFirst())
    val p2 = stack.push(points.pollFirst())
    for (point in points) {
        while (stack.size >= 2 && ccw(point, stack[stack.size - 2], stack.peek()) < 0) {
            stack.pop()
        }
        stack.push(point)
    }
    val elsePoints = mutableListOf<Point>()
    points.add(p2)
    val stackSet = stack.toSet()
    for (point in points) {
        if (!stackSet.contains(point)) {
            elsePoints.add(point)
        }
    }
    elsePoints.sortWith(compareBy { dist(points[0], it) })
    for (point in stack) {
        bw.write("${point.x} ${point.y}\n")
    }
    elsePoints.reversed().forEach { point ->
        bw.write("${point.x} ${point.y}\n")
    }
}

fun ccw(a: Point, b: Point, c: Point): Long {
    return a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y
}

fun ccwCompare(a: Point, b: Point, c: Point): Int {
    val ccw = ccw(a, b, c)
    return when {
        ccw > 0 -> 1
        ccw == 0L -> 0
        else -> -1
    }
}

fun dist(p1: Point, p2: Point): Long {
    return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)
}
