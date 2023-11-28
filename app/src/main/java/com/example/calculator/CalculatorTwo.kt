// 연산을 나타내는 인터페이스
interface Sample {
    fun calculate(num1: Double, num2: Double): Double
}

// 덧셈 연산 클래스
 class Add : Sample {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

// 뺄셈 연산 클래스
class Sub : Sample {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

// 곱셈 연산 클래스
class Mul : Sample {
    override fun calculate(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

// 나눗셈 연산 클래스
class Div : Sample {
    override fun calculate(num1: Double, num2: Double): Double {
        if (num2 != 0.0) {
            return num1 / num2
        } else {
            throw ArithmeticException("0으로 나눌 수 없습니다.")
        }
    }
}

fun performCalculation(num1: Double, num2: Double, operator: Sample): Double {
    return try {
        operator.calculate(num1, num2)
    } catch (e: ArithmeticException) {
        println(e.message)
        Double.NaN // 에러가 발생한 경우 NaN 반환
    }
}

fun main() {
    println("두 숫자와 연산을 입력하여 계산합니다.")

    print("첫 번째 숫자를 입력하세요: ")
    val num1 = readLine()?.toDoubleOrNull() ?: run {
        println("올바른 숫자를 입력하세요.")
        return
    }

    print("두 번째 숫자를 입력하세요: ")
    val num2 = readLine()?.toDoubleOrNull() ?: run {
        println("올바른 숫자를 입력하세요.")
        return
    }

    println("연산을 선택하세요:")
    println("1. 덧셈 (+)")
    println("2. 뺄셈 (-)")
    println("3. 곱셈 (*)")
    println("4. 나눗셈 (/)")
    print("원하는 연산의 번호를 입력하세요: ")

    val choice = readLine()?.toIntOrNull()

    val operation: Sample = when (choice) {
        1 -> Add()
        2 -> Sub()
        3 -> Mul()
        4 -> Div()
        else -> {
            println("잘못된 선택입니다.")
            return
        }
    }

    val result = performCalculation(num1, num2, operation)
    println("결과: $result")

    println("계산을 종료합니다.")
}
