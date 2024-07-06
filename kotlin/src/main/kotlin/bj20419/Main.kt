package bj20419

import java.io.*

val du = Pair(-1, 0)
val dd = Pair(1, 0)
val dl = Pair(0, -1)
val dr = Pair(0, 1)
val d = listOf(du, dr, dd, dl)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(r) { br.readLine().toCharArray() }
    if (k == 0) {
        if (bfsNoScroll(r, c, arr)) {
            println("Yes")
        } else {
            println("No")
        }
    } else {
        if (bfs(r, c, arr)) {
            println("Yes")
        } else {
            println("No")
        }
    }
}

fun bfs(ySize: Int, xSize: Int, arr: Array<CharArray>): Boolean {
    val visited = Array(ySize) { Array(xSize) { Array(2) { BooleanArray(2) } } }
    val queue = mutableListOf<Triple<Int, Int, Pair<Int, Int>>>()
    queue.add(Triple(0, 0, Pair(0, 0)))
    visited[0][0][0][0] = true
    while (queue.isNotEmpty()) {
        val (y, x, scroll) = queue.removeAt(0)
        if (y == ySize - 1 && x == xSize - 1) {
            return true
        }
        val (dy, dx) = charToDir(arr[y][x])
        val (ny, nx) = Pair(y + dy, x + dx)
        if (!(ny < 0 || ny >= ySize || nx < 0 || nx >= xSize) && !visited[ny][nx][scroll.first][scroll.second]) {
            visited[ny][nx][scroll.first][scroll.second] = true
            queue.add(Triple(ny, nx, scroll))
        }

        if (scroll.first == 0) {
            val rotateRight = rotateRight(arr[y][x])
            val (rotateDy, rotateDx) = charToDir(rotateRight)
            val (ry, rx) = Pair(y + rotateDy, x + rotateDx)
            if (!(ry < 0 || ry >= ySize || rx < 0 || rx >= xSize) && !visited[ry][rx][1][scroll.second]) {
                visited[ry][rx][1][scroll.second] = true
                queue.add(Triple(ry, rx, Pair(1, scroll.second)))
            }
        }
        if (scroll.second == 0) {
            val rotateLeft = rotateLeft(arr[y][x])
            val (rotateDy, rotateDx) = charToDir(rotateLeft)
            val (ry, rx) = Pair(y + rotateDy, x + rotateDx)
            if (!(ry < 0 || ry >= ySize || rx < 0 || rx >= xSize) && !visited[ry][rx][scroll.first][1]) {
                visited[ry][rx][scroll.first][1] = true
                queue.add(Triple(ry, rx, Pair(scroll.first, 1)))
            }
        }
    }
    return false
}

fun bfsNoScroll(ySize: Int, xSize: Int, arr: Array<CharArray>): Boolean {
    val visited = Array(ySize) { BooleanArray(xSize) }
    val queue = mutableListOf<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    visited[0][0] = true
    while (queue.isNotEmpty()) {
        val (y, x) = queue.removeAt(0)
        if (y == ySize - 1 && x == xSize - 1) {
            return true
        }
        val (dy, dx) = charToDir(arr[y][x])
        val (ny, nx) = Pair(y + dy, x + dx)
        if (ny < 0 || ny >= ySize || nx < 0 || nx >= xSize) {
            continue
        }
        if (visited[ny][nx]) {
            continue
        }
        visited[ny][nx] = true
        queue.add(Pair(ny, nx))
    }
    return false
}

fun charToDir(c: Char): Pair<Int, Int> {
    return when (c) {
        'U' -> du
        'D' -> dd
        'L' -> dl
        'R' -> dr
        else -> throw Exception("Invalid")
    }
}

fun rotateRight(c: Char): Char {
    return when (c) {
        'U' -> 'R'
        'R' -> 'D'
        'D' -> 'L'
        'L' -> 'U'
        else -> throw Exception("Invalid")
    }
}

fun rotateLeft(c: Char): Char {
    return when (c) {
        'U' -> 'L'
        'L' -> 'D'
        'D' -> 'R'
        'R' -> 'U'
        else -> throw Exception("Invalid")
    }
}
