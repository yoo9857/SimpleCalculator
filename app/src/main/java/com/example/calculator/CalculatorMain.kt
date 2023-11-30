
fun main() {
    var calculator: String = "+" // 초기값을 "+"로 설정
    var firstNumber: Double = 0.0
    var secondNumber: Double = 0.0

    // 첫 번째 숫자 입력
    print("숫자를 입력해주세요: ")
    while (true) {
        val input = readLine()
        if (input != null) {
            firstNumber = input.toDoubleOrNull()!!
            if (firstNumber != null) {
                break
            } else {
                println("제대로 입력해주세요")
            }
        }
    }

    // 두 번째 숫자 입력
    print("숫자를 입력해주세요: ")
    while (true) {
        val input = readLine()
        if (input != null) {
            secondNumber = input.toDoubleOrNull()!!
            if (secondNumber != null) {
                break
            } else {
                println("제대로 입력해주세요")
            }
        }
    }

    // 연산자 입력
    print("연산자를 입력해주세요 (+, -, *): ")
    while (true) {
        val input = readLine()
        if (input != null) {
            calculator = input
            if (calculator in setOf("+", "-", "*")) {
                break
            } else {
                println("옳바르게 입력해주세요 (+, -, *, /)")
            }
        }
    }

    // 연산 수행
    when (calculator) {
        "+" -> println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
        "-" -> println("$firstNumber - $secondNumber = ${firstNumber - secondNumber}")
        "*" -> println("$firstNumber * $secondNumber = ${firstNumber * secondNumber}")
        "/" -> println("$firstNumber * $secondNumber = ${firstNumber / secondNumber}")
        else -> println("Invalid operator")
    }
}
