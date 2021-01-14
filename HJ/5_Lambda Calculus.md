# Lambda Calculus

#### 개념 기초 위주로 공부~!

## 람다 대수
직관적으로 계산 가능한 모든 것들을 표현할 수 있으며 소프트웨어가 계산하는 과정을 람다 대수를 이용하여 표현할 수 있다
- 함수형 프로그래밍    
    Haskell이나 여타의 함수형 프로그래밍에서 일반적으로 first-class로 부르며 함수를 값, 인수, 또는 입력으로 사용할 수 있다. 함수형 프로그래밍 언어는 람다 대수를 기반으로 한다
- 하스켈은 순수 함수형 언어이다
    -  '순수'(pure)는 참조 투명성이라 불리는 것을 의미하는 것으로, 참조 투명성이란 동일한 함수를 평가할 때 순수 함수형 언어는 항상 같은 결과를 반환한다는 것을 의미

- 람다 표현식(λ-expression)   
    - expression : 모든 구성요소의 상위 집합으로,variable 또는 abstraction(일반적으로 function으로 정의) 혹은 그것들을 결합
        ##### ex) 가장 간단한 expression은 single variable(단일 변수)
    - variable :  어떤 의미나 값을 나타내는 것이 아니라 함수의 입력을 위한 이름 (매개변수)
    - abstraction :  기능(function)으로, 로, head와 body를 가지고 있으며 head는 λ(lambda)와 variable, body는 또 다른 expression이며 이름을 지정하지 않는다
    - 형태
        - 𝑓(𝑥) = 𝑥를 람다 대수 형태로 나타낸 λx.x에서 λx는 head
        - head에서 x는 단일 **매개 변수**로 body에서 같은 이름의 모든 변수와 연결된다
        - . 이후에 위치한 x는 body로 람다가 적용되었을 때 반환하는 표현 (bound variable, **본문부분**)
- Alpha equivalence    
    variable은 placeholder 역할, 𝜆𝑥.𝑥, 𝜆𝑑.𝑑 그리고 𝜆𝑧.𝑧은 동일한 람다 대수
- Beta reduction  
    -변수를 바인딩하여 하는 과정하여 head를 축약하는 과정
    ex) **(𝜆𝑥.𝑥) 2** .x에 2 대입 𝜆 제거
    -함수의 적용(application)은 왼쪽으로 결합
    -λ𝑦.𝑦 𝑧에서 모든 𝑦는 𝑧로 대체된다는 것을 표현하기 위해서 [𝑦 : = 𝑧] 표기법을 사용한다.
    - 계산 예시
        ```
        (𝜆𝑥.𝑥)(𝜆𝑦.𝑦)𝑧
        == ((𝜆𝑥.𝑥)(𝜆𝑦.𝑦))𝑧  // (𝜆𝑥.𝑥)(𝜆𝑦.𝑦)에 𝑧를 적용
        == [𝑥 ∶= (𝜆𝑦.𝑦)]𝑧   // 𝜆𝑥.𝑥에서 𝑥는 (𝜆𝑦.𝑦)로 축약
        == (𝜆𝑦.𝑦)𝑧          // (𝜆𝑦.𝑦)에 𝑧를 적용
        == [𝑦 ∶= 𝑧]         // (𝜆𝑦.𝑦)에서 𝑦는 𝑧로 축약
        == 𝑧                // 𝑧를 축약
        ```
- Free variables
    λ로 시작하지 않는 variable을 free variable(자유 변수) 혹은 non-local(비지역)
    ex) 𝜆𝑥.𝑥𝑦에서 자유 변수는 𝑦
- Multiple arguments  
    - 여러개의 인수가 필요한 함수에서는 여러 개의 중첩 된 head가 있으므로 맨 왼쪽의 첫 번째 head부터 하나씩 제거한다.
    - currying(커링)
        ```
        def modN(n: Int)(x: Int) = ((x % n) == 0)
        def modTwo = modN(2) _
        println(modTwo(4))
        ```
    커링을 이용해서 n 값을 미리 바인딩 하는 다른 함수로 선언하거나, 다른 함수의 파라미터로 전달할 수 있다
    - 의문
        ```
        (𝜆𝑥𝑦𝑧.𝑥𝑧(𝑦𝑧))(𝜆𝑚𝑛.𝑚)(𝜆𝑝.𝑝)
        = (𝜆𝑥.𝜆𝑦.𝜆𝑧.𝑥𝑧(𝑦𝑧))(𝜆𝑚.𝜆𝑛.𝑚)(𝜆𝑝.𝑝)
        = (𝜆𝑦.𝜆𝑧(𝜆𝑚.𝜆𝑛.𝑚)𝑧(𝑦𝑧))(𝜆𝑝.𝑝)
        = 𝜆𝑧(𝜆𝑚.𝜆𝑛.𝑚)(𝑧)((𝜆𝑝.𝑝)𝑧)   // 여기는 왜 m부터 될까?
        = 𝜆𝑧(𝜆𝑛.𝑧)((𝜆𝑝.𝑝)𝑧)
        = 𝜆𝑧.𝑧
        = 𝑧
        ```
<br/>
<hr/>

## Reference

[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[람다 대수](https://www.sangkon.com/haskell-study-part02/)   
[커링](https://wikidocs.net/29770)

<br/>

### 나중에 추가로 보면 좋을 듯 한 거
[람다 대수 문제](https://helloworld.kurly.com/blog/lambda-calculus-1/)