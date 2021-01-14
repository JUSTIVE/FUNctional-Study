# Lazy Evaluation

## 게으른 평가
- 값이 필요할 때까지 표현식의 평가를 유지하는 평가 전략으로 반복적인 평가를 피한다
- 장점
    -언어 런타임은 표현식의 최종 결과에 직접 연결되지 않은 하위 표현식을 삭제할 수 있
    - 시 계산 및 조건을 삭제하여 알고리즘의 시간 복잡성을 줄인다
    - 데이터 구조의 구성 요소를 초기화 한 후 순환 종속성이없는 한 순서없이 액세스 가능
    - 자주 액세스하지 않는 데이터를로드하는 데 가장 적합
- 단점
    - 썽크 (지연된 개체, thunk)를 만들어 최종 결과에 필요할 때까지 언어 런타임이 하위 식의 평가를 유지한다
        ##### thunk : 표현식의 평가되지 않는 형태
    - 알고리즘의 공간 복잡성을 증가시킬 수 있다
- in Scala
    - 스칼라의 대부분은 엄격한 함수
    - argument로 받은 함수(thunk)는 참조될때마다 평가된다 - 캐싱X
        ```
        scala> def maybeTwice(b: Boolean, i: => Int) = if (b) i+i else 0
        maybeTwice: (b: Boolean, i: => Int)Int

        scala> val x = maybeTwice(true, { println("hi"); 1+41 })
        hi
        hi
        x: Int = 84
        ```
    - **lazy** 키워드를 이용하여 캐싱을 적용한다 → 결과가 단 한 번만 평가된다
    - 즉, 우변의 평가를 우변이 처음 참조될 때까지 지연하고 평가 결과를 캐시에 담아두었다가 이후의 참조에서는 평가를 되풀이하지 않는다 
        ```
        scala> def maybeTwice2(b: Boolean, i: => Int) = {
        | lazy val j = i
        | if (b) j+j else 0
        | }
        maybeTwice: (b: Boolean, i: => Int)Int

        scala> val x = maybeTwice2(true, { println("hi"; 1+41)})
        hi
        x: Int = 84
        ```
    -  늦은 초기화 지원
        ```
        var a = 3
        lazy val b = a + 3
        a += 1
        println(b)  // 7
        ```

<br/>
<hr/>

## Reference
[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[lazy](https://medium.com/@lazysoul/%EC%97%84%EA%B2%A9%EC%84%B1%EA%B3%BC-%EB%82%98%ED%83%9C%EC%84%B1-lazy-stream-27a1aaf1b49d)   
[lazy2](https://storyzero.gitbooks.io/functional-programming-in-scala/content/chapter5.html)   
[lazy3](https://knight76.tistory.com/entry/scala-lazy-view )