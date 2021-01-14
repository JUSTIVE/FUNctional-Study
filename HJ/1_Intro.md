# Introduction

## 함수형 프로그래밍
- 언어
    - Pure Functional Languages(순수 함수형 언어) : 함수형 프로그래밍 패러다임 지원 ex) Haskell
    - Impure Functional Languages (불순 함수형 언어)   : 함수형 프로그래밍 패러다임 + 명령형 프로그래밍 지원 ex) LSIP

- 특성
    - 조건식과 재귀를 사용하여 계산을 수행하는 수학 함수의 개념에 따라 설계
    - 고차 함수
    - 지연 연산
    - 루프 문과 같은 흐름 제어와 If-Else 및 Switch 문과 같은 조건문을 지원X
    - 순수 함수와 보조 함수의 조합을 이용해서 로직 내에 존재하는 조건문과 반복문을 제거 -> 복잡성을 없애고, 변수의 사용을 억제하여 상태 변경을 피할 수 있음

- 맛보기
    - 순수 함수   
    함수의 실행이 외부에 영향을 끼치지 않는 함수 - 스레드-세이프, 병렬 계산   
        ```
        public int add(int a, int b) {
            return a + b;
        } 
        ```

    - 고차 함수   
    함수를 인수로 취하는 함수 - 함수를 입력 파라미터나 출력값으로 처리
        ```
        Collections.sort(new ArrayList<Integer>(), (x, y) -> x >= y ? -1 : 1); 
        ``` 
<br/>

- 함수형 VS 객체 지향
    |     |함수형|객체 지향|
    |-----|------|--------|
    |데이터|불변|가변|
    |프로그래밍 모델|선언형 따름|명령형 따름|
    |초점|What|How|
    |병렬 프로그래밍|적합|부적합|
    |부작용|X|O|
    |흐름 제어|함수 호출 및 재귀|루프와 조건문|
    |반복문|재귀|루프|
    |실행 순서|중요하지 않음|매우 중요|
    |추상화|데이터, 행동의 추상화|데이터 추상화|
<br/>

## Scala 개요 및 특징
- high-level language
- OOP, FP(Functional Programming)  패러다임 지원
- 자바가상머신(JVM)에서 동작하는 JVML언어
    ##### 그 밖에 kotlin, Groovy 등이 있음
    - 스칼라는 스칼라 컴파일러를 통해 스칼라 코드를 바이트 코드로 변환
    - JAVA 라이브러리 사용이 쉬움
- 짧은 코드길이
    - 겟터, 셋터, 생성자를 제거
    - 표현식 간소화 
- 바이트 코드 최적화 (자바보다 20%정도 속도가 빠름)
- 동시성에 강함
    - 변경 불가능한 Immutable 변수
    - 속성을 변경 불가능하게 함
    - 순수 함수를 사용하여 병렬 프로그래밍 처리에 강함
        
<br/>
<hr/>

## Reference
[tutorialspoint](https://www.tutorialspoint.com/functional_programming/index.htm)  
[빅데이터 - 스칼라(scala), 스파크(spark)로 시작하기](https://wikidocs.net/book/2350)