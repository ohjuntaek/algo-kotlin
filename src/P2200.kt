fun main() {
    val n = readLine()!!.toInt()
    val coeffArr = readLine()!!.split(' ') // It's a string array

    var count = 1 // The first 'x' key
    for (i in 1..n) {
//        println(coeffArr[i])
        val coeff = coeffArr[i] // It's a string

        if (i > 1) { // On the first step, we don't need to press '*' key
            count += 2 // '*' and 'x' key
        }
        if (coeff != "0") {
            count++ // '+' key
            count += coeff.length
        }
    }
    count++ // '=' key
    print(count)
}