## 개요
함수는 특정 작업을 수행하기 위한 블록으로 데이터를 받아 처리하고 결과를 반환한다. 재사용의 개념을 지원하기 위해 작성하며 동일한 코드를 반복해서 작성하지 않고도 쉽게 호출할 수 있다.

## 함수의 조건
- 기능의 목적
- 알고리즘
- 변수와 목표
- 함수의 데이터

---

## 함수 프로토타입
반환 유형, 함수 이름 및 인수 목록을 포함하는 함수 선언이다. 함수 본문이 없는 함수의 정의와 유사하다.

## 함수 시그니쳐
함수 시그니처는 매개 변수의 수, 매개 변수의 데이터 유형 및 출현 순서가 유사한 순서로 되어있어서 함수 프로토 타입과 유사하다.
> 함수에 명시되는 매개변수 리스트를 가리킨다.
> 함수 오버로딩과 오버라이드는 함수시그니처의 개념을 기반으로 한다.

---

## Call by Value, Call by Reference

|Call by Value|Call by Reference|
|---|---|
|값에 의한 호출로 변수에 할당 된 값만을 복사해서 함수의 인자를 넘김|참조(주소)에 의한 호출로 인자로 넘어간 값이 함수 내부에서 변경되면서 실제로 값이 변경됨|

**call-by-assignment**
- python은 call-by-assignment를 사용한다.
- 모든 것이 객체인 python은 전달하는 인자가 가변(mutable)인지 불변(immutable)인지에 따라 전달 방식이 달라진다.
- 불변 : call by value, 가변 : call by reference

### Function Overloading, Overriding
|구분|Overloading|Overriding|
|---|---|---|
|함수명|동일|동일|
|파라미터 수,타입|다름|동일|
|반환 타입|상관없음|동일|

---

***Reference***

[tutorialspoint - Learn Functional Programming](https://www.tutorialspoint.com/functional_programming/functional_programming_functions_overview.htm)