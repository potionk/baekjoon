package bj29751

fun main() {
    val (w, h) = readLine()!!.split(" ").map { it.toDouble() }
    println(w * h / 2)
}
