package bj3679

import java.io.*
import java.util.*

data class Point(val x: Int, val y: Int, val index: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val points = LinkedList<Point>()
        val pointInfo = br.readLine().split(" ")
        for (j in 1 until pointInfo.size step 2) {
            val x = pointInfo[j].toInt()
            val y = pointInfo[j + 1].toInt()
            points.add(Point(x, y, j / 2))
        }
        points.sortWith(compareBy({ it.x }, { it.y }))
        val p0 = points[0]
        points.sortWith { a, b ->
            val ccw = ccwCompare(p0, a, b)
            if (ccw != 0) ccw else dist(p0, a) - dist(p0, b)
        }

        var reverseIdx = points.size - 1
        for (j in points.size - 1 downTo 1) {
            if (ccwCompare(points[0], points[reverseIdx], points[reverseIdx - 1]) == 0) {
                reverseIdx--
            } else {
                break
            }
        }
        points.subList(reverseIdx, points.size).reverse()

        points.forEach {
            bw.write("${it.index} ")
        }
        if (i != t - 1) {
            bw.write("\n")
        }
    }
    bw.close()
}

fun ccw(a: Point, b: Point, c: Point): Int {
    return a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y
}

fun ccwCompare(a: Point, b: Point, c: Point): Int {
    val ccw = ccw(a, b, c)
    return when {
        ccw > 0 -> 1
        ccw == 0 -> 0
        else -> -1
    }
}

fun dist(p1: Point, p2: Point): Int {
    return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y)
}
