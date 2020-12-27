# 람다 대수 Lambda Calculus
[reference](https://www.sangkon.com/haskell-study-part02/)  
- 1930년도 알론조 처치`Alonzo Church`가 발표한 계산 모델  
- 결정 문제`decision problem`를 해결
- 계산 가능성`computability` 혹은 계산 가능한 함수`computable function`의 정의
- 함수형 언어의 계산 모델

힐베르트`David Hilbert`에 의해 명제->참/거짓 의 알고리즘을 연구  
괴델에`Kurt Godel` 의해 위의 알고리즘은 존재하지 않고, 존재할 수 없음을 불완전성 정리`imcompleteness Theorem` 으로 증명  
불완정성 정리에서는 모든 수학적인 논리 체계 하에서는 논리 자체적으로 증명할 수 없는 문제가 존재함을 나타냄.  
따라서 많은 사람들은 풀 수 있는 문제에 연구를 수행

- 클레이너`Kleene Star`->알론조 처치`Alonzo Church`:Recursive function
- 알론조 처치`Alonzo Church`:Lambda Calculus
- 에밀 레온 포스트`Emil Leon Post`:Post Canonical Systems
- 앨런 튜링`Alan Turing`:튜링 기계

이후 1937년도에 튜링과 처치가 독자적인 연구를 바탕으로 모든 계산 가능한 연산은 처치의 방법을 쓸 수 있고, 이 역도 성립함이 증명됨.  
이는 람다 대수는 임의의 튜링 기계`Turing Machine`을 시뮬레이션 할 수 있는 보편적인 계산 모델로서, 튜링 완전`Turing Complete` 함을 의미하고, 계산 가능성 이론`Computability Theory`가 객관적이고 수학적인 특성을 가짐을 의미

>튜링 기계`Turing Machine`  
>[reference](https://en.wikipedia.org/wiki/Turing_machine#:~:text=A%20Turing%20machine%20is%20a,algorithm's%20logic%20can%20be%20constructed.)  
>- 수학적 모형으로, 특수한 테이프를 이용하여 동작하는 기계
>- 유한한 개수의 기초적 지시문으로 이루어진 테이프
>- `On computable numbers, with an application to the Entscheidungsproblem`
>
>호프크로프트`Hopcroft`와 울만`Ullman`은 단일 테이프 튜링 기계를 M = <Q,Γ,b,Σ,δ,q_0,F>로 정의  
>|기호|의미|
>|---|---|
>|Q|유한하고 비어있지 않은 상태들의 집합|
>|Γ|유한하고 비어있지 않은 기호와 알파벳들의 집합|
>|b∈Γ|비어있음을 알려주는 기호(테이프 위에서 유일하게 무한하게 나타날 수 있는 기호)|
>|q_0∈Q|초기 상태|
>|F⊆Q|최종 상태, 혹은 수락 상태
>|δ|Q/F×Γ→Q×Γ×{L,R} (부분함수)
>위의 정의를 바탕으로 작동하는 모든 것은 튜링 기계로 불림

>튜링 완전`Turing Complete`  
>[reference](https://ko.wikipedia.org/wiki/%ED%8A%9C%EB%A7%81_%EC%99%84%EC%A0%84)  
>어떤 프로그래밍 언어나 추상 기계가 튜링 기계와 동일한 계산 능력을 가진다는 의미.
>제한 없는 기억장치를 포함한 장치는 물리적으로 불가능하므로, 기억 장치가 늘어난다는 가정 하에 `느슨한 튜링 완전`으로 간주한다.

>계산 가능성 이론`Computability Theory`

## 함수의 표현

항등 함수 
```math
I(x)=x
```

- 함수는 이름을 가질 필요는 없다: 위의 항등 함수`I(x) = x`는 `x → x`의 형태로 쓸 수 있다.
- 함수의 입력 변수의 이름도 필요 없다.`x → x`는 `y → y` 와 같다
- 두 개 이상의 입력을 받는 함수는 하나의 입력을 받아 또 다른 함수를 출력하는 형태로 다시 쓸 수 있다.`커링`
  - ex) `(x,y) → x * x + y * y`에 대해서
  - x → (y → x * x + y * y)(5)(2)
  - = (y → 5 * 5 + y * y)(2)

## 람다 대수
람다 대수는 특정 형식 언어이며 람다 용어의 변형을 가능하게 하는 변형 규칙 집합인 람다 용어로 구성되어 있다. 이러한 변형 규칙은 보편 대수학 혹은 조작적 정의로 볼 수 있다.

람다 대수의 모든 함수는 익명이며, 하나의 입력 변수만 허용하고, 커링을 통해 여러 변수를 받는 함수를 구현한다.

### 람다 용어
