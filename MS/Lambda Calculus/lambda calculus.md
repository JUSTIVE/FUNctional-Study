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
>호프크로프트`Hopcroft`와 울만`Ullman`은 단일 테이프 튜링 기계를 M = <Q,Γ,b,Σ,δ,q_0,F>로 정의  
>|기호|의미|
>|---|---|
>|Q|유한하고 비어있지 않은 상태들의 집합|
>|Γ|유한하고 비어있지 않은 기호와 알파벳들의 집합|
>|b∈Γ|비어있음을 알려주는 기호(테이프 위에서 유일하게 무한하게 나타날 수 있는 기호)|
>|q_0∈Q|초기 상태|
>|F⊆Q|최종 상태, 혹은 수락 상태
>|δ|Q/F×Γ→Q×Γ×{L,R} (부분함수)
