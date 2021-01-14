# Higher Order Functions

## 고차함수 (HOF)
- 다음 조건 중 하나 이상을 따르는 함수
    - 하나 이상의 함수를 인수로 갖는다
    - 결과로 함수를 반환한다
- 함수형 언어는 함수를 **일급 객체(first-class)값**으로 다룸 → 함수를 값처럼 매개변수로 전달하고 결과 반환

- 고차함수를 이용한 더하기 예제
    ```
    def sum(f: Int => Int, a: Int, b: Int): Int =
      if (a > b) 0
     else f(a) + sum(f, a + 1, b)   

    def id(x: Int): Int = x
    def sumInts(a: Int, b: Int) = sum(id, a, b)
    ```

- 함수 타입  
**A => B**의 타입은 함수!! 함수 형태인 A argument 를 입력한 결과를 B 라는 결과로 리턴한다 → Int => Int는 int를 int로 맵핑하는 함수

- 익명함수   
함수 리터럴에 이름을 주지않고 함수를  작성하는 것   
→ 우리는 **string** 값을 println에 바로 대입할 수 있다 Why? string은 **리터럴(literals)** 로 존재하기 때문!!   
유사하게 함수 리터럴도 쓰기를 원하기 때문에 익명 함수가 존재
    ```
    (x: Int, y: Int) => x + y
    ```

- 익명함수를 이용한 더하기 예제
    ```
    def sumInts(a: Int, b: Int) = sum(x => x, a, b)
    def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
    ```

<br/>

- 함수 호출 방식
    ##### => 이해를 위해 추가로 찾아본 것
    - Call by value (값에 의한 호출)   
    함수가 호출되기 전에 파라미터의 값이 미리 정해진다
        ```
        def callByValue(x: Int) = {
            println("x1 = " + x)
            println("x2 = " + x)
        }
        ```
    - Call by name (이름에 의한 호출)   
    값이 필요할 때마다 평가된다
        - callByName(x: => Int)라는 표현은 callByName(x: () => Int)을 줄여서 표현한 것으로 생각할 수 있다
        ```
        def callByName(x: => Int) = {
            println("x1 = " + x)
            println("x2 = " + x)
        }
        ```
    - 사용 예제
        ```
        def something(): Int = {
          println("calling something")
          1     // = return 1 (return 생략가능)
        }
        ```
        ```
        scala> callByValue(somthing())
        calling something
        x1 = 1
        x2 = 1

        scalla> callByName(something())
        calling something
        x1 = 1
        calling something
        x2 = 1
        ```

<br/>
<hr/>

## Reference
[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[고차함수](https://sehajyang.github.io/2019/07/11/higher-order-function/)   
[함수 호출 방식](https://medium.com/@OutOfBedlam/scala-call-by-value-vs-call-by-name-734a79c75ccb)