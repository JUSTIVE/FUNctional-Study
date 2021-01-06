# Recursion

## 재귀 함수
- 자신을 호출하는 함수
- 특징
    - 무한 루프에 빠지지 않기 위해 일정한 탈출 조건이 있어야 한다
    - 코드를 단순화할 수 있다
    - 출 시마다 스택 공간을 이용하므로 무리하게 호출하면 스택 오버플로우가 발생할 수 있다
    - 재귀 함수의 호출 횟수는 스택의 남은 공간과 재귀 함수의 지역 변수 사이즈에 따라 달라진다
    - 디버깅 및 실행 흐름을 파악하기 힘들다
- 일반적인 재귀함수
    ```
    function factorial(n) {
    if (n === 1) return 1;
    return n * factorial(n -1);
    }
    ```

## 꼬리 재귀 (Tail Recursion)
- 재귀 단점을 보완하기 위한 최적화 방법
- 재귀함수의 콜 스택이 깊어질수록 메모리 오버헤드 (스택 오버 플로우 stack overflow)가 발생하는 문제를 해결하기 위한 재귀 호출 방식
- 재귀 호출이 끝난 후 현재 함수에서 추가 연산을 요구하지 않도록 구현하는 재귀의 형태
- 컴파일러가 꼬리 재귀 최적화 기능을 지원하는지 먼저 확인 필요
    ```
    function factorialTail(n, acc) { //acc: accumulator
      if (n === 1) return acc;
      return factorialTail(n - 1, acc * n); 
    //일반 재귀에서의 n * factorial(n - 1)과 달리 반환값에서 추가연산이 필요없음
    }
    function factorial(n) {
      return factorialTail(n, 1);
    }
    ```
- in Scala
    - **@tailrec**주석을 사용하여 함수가 꼬리 재귀가 되도록 요구 
    - 어노테이션이 있는 구현이 꼬리 재귀가 아닌 경우 오류 발생
    ```
    def factorial(n: Int): Int = {
      @tailrec
      def iter(x: Int, result: Int): Int =
        if (x == 1) result
        else iter(x - 1, result * x)

    iter(n, 1)
    }
    ```
<br/>
<hr/>

## Reference
[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[scala-exercies 번역본](https://sehajyang.github.io/2019/07/11/tail-recursion/)   
[꼬리 재귀](https://medium.com/@soyoung823/tail-recursion-%EA%BC%AC%EB%A6%AC-%EC%9E%AC%EA%B7%80-a84c2cd9a7e8)