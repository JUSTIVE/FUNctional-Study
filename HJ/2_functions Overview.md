# Introduction

## Scala 함수
- 함수   
    - 특정 작업을 수행하는 문 블록으로, 데이터를 받아 처리하고 결과를 반환하며 동일한 코드를 반복해서 작성하지 않고 호출이 가능하다.

<br/>

- **def**로 함수를 선언   
    ```
    def add(x: Int, y: Int): Int = {
    return x + y
    }
    ```

- 함수를 선언할 때 리턴문과 리턴 타입은 생략 가능
    - 매개변수의 파라미터 타입은 생략X
    - 리턴값이 없는 함수를 선언할 때는 **Unit**을 이용 ( 얘도 생략가능)
    - 함수의 매개변수는 불변 변수로 재할당 불가
    - 리턴 타입을 생략하면 컴파일러가 반환값을 이용하여 자동으로 추론
    ```
    def add(x: Int, y: Double) = {
      x + y
    }
    ```

- 함수의 축약형   
    - 중괄호 없이 선언 가능
    ```
    def printUpper(message:String):Unit = println(message.toUpperCase())
    ```

- 파라미터 기본값 설정   
    - 파라미터 개수대로 전달하지 않으면 기본값 이용
    ```
    def add(x: Int, y: Int = 10): Unit = {
      println(x + y)
    }
    ```

- 가변 길이 파라미터   
    * *를 이용하면 **Seq**형으로 변환되어 입력
    ```
    def sum(num:Int*) = num.reduce(_ + _)

    scala> sum(1, 2, 3)
    res22: Int = 6
    ```

 - 변수에 함수 결과 할당   
    - 함수를 **def**로 선언하지 않고 **var**, **val**로 선언
    ```
    val random1 = Math.random()
    ```

- 함수의 중첩
    ```
    def run() {
        def middle() {
            println("middle")
        }

        println("start")
        middle()
        println("end")
    }
    ```
<br/>
<hr/>

## Reference
[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[빅데이터 - 스칼라(scala), 스파크(spark)로 시작하기](https://wikidocs.net/26141)