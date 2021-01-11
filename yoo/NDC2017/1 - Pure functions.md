## 순수함수 - Pure functions
함수형 프로그래밍은 가능한 모든함수를 순수함수로 프로그래밍하는 것을 목표로 하는데 `순수함수`란 수학에서 사용하는 함수의 개념인데 일반적으로 수학에서 함수란 아래와 같이 정의한다.

> 임의의 원소 x ∈ X 에 대해, 그에 대응하는 원소 y ∈ Y 가 유일하게 존재한다.
> 
> f: x -> y

이러한 정의를 가진 함수를 생각해보면 x라는 입력이 있다면 그에 대응하는 y가 유일하게 존재해야 한다. 즉, 결과값인 y가 유일하지 않다면 함수가 아니다.

- 함수의 결과값이 오직 입력 인자 값들에 의해서만 결정
- 특정 입력 값에 대해서 결과값이 결정적으로 대응되는 함수
- `부작용(Side effects)`이 없는 함수

```python
def plus(a,b):
    return a + b

print(plus(1,2))
```

`비순수함수`는 동일한 입력에 대해서 다른 결과값을 보여준다.

```python
some_list = []

def impure(arg):
    some_list.append(arg)
    return print(some_list)

impure(1)
impure(2)
```

입력값에 대해서 항상 같은 결과를 내기 위해선 상태를 갖지 않아야 하는데 여기서 `부작용(Side effects)` 라는 개념이 나온다.

## 부작용 - Side effects

상태에 영향을 받거나 변화를 주는 모든 동작으로 예를 들면 아래와 같은 걸 생각할 수 있다.
- 화면출력
- 디스크 I/O
- 예외 catch

## 참조 투명성 - Referential transparency

이처럼 순수함수를 사용하여 부작용을 최소화하는 목적은 `참조 투명성(Referential transparency)`을 얻기 위함이다.

- 어떤 표현식을 그 표현식의 결과값으로 교체해도 전체 프로그램의 실행결과에 영향을 주지 않는 성질

>만약 인자가 1로 들어갈 때 결과가 2로 나오는 순수함수가 있을 때 그 함수의 호출이 무조건 1로 된다면 함수가 사용된 부분을 나와야하는 결과값인 2로 대체하더라고 전체 프로그램 실행에 영향이 없음을 의미하는데 이는 함수를 평가하고 연산하는데 드는 연산비용을 없앨 수 있음을 의미한다.

- 컴파일러에게 다양한 최적화 기회를 제공
  - 기억 - Memoization
    - 결과값을 기억했다가 다시 사용하는 대표적인 최적화
    - 입력값 / 함수명을 알면 결과값은 항상 같음
  - 지연연산 - Lazy evaluation
    - 함수의 입력값과 함수명을 계속 들고 있다가 실제로 결과값이 필요할 때만 함수를 평가

## FP 실천사항 #1 - 순수함수

1. 코드에서 가능한 순수함수의 비율이 많아지도록 하자
   - 글로벌 변수, 멤버 변수 의존도를 줄이자
   - 상태를 없애거나 줄이고 부작용을 격리시키자

2. 함수는 인자를 받아서 값을 리턴하는 형태로 만들자
   - 레퍼런스 인자보다는 값을 리턴
   - 여러 개의 값을 리턴할 때는 tuple을 사용

## Memoization

동적계획법의 핵심이 되는 기술로 이전에 계산한 값을 메모리에 저장함으로써, __동일한 계산의 반복 수행을 제거__ 하여 프로그램 실행 속도를 빠르게 하는 기술로 동일한 input에 대해 동일한 output이 나오는 함수인데 실행 비용이 비싼 경우 적용할 수 있다.

```python
from functools import lru_cache

# 인자들을 cache 딕셔너리에 들어있는지 검사하고 들어있지 않다면 함수의 실행결과를 저장하여 나중에 똑같은 인자를 통해 해당 함수를 다시 호출했을 때 cache 딕셔너리에 저장된 값을 즉시 반환한다.
def memoize(f):
    cache = {}
    def decorated_function(*args):
        if args in cache:
            return cache[args]
        else:
            cache[args] = f(*args)
            return cache[args]
    return decorated_function

@memoize
def fibo2(n):
    return n if n < 2 else fibo(n-2) + fibo(n-1)

# python3.2 이상에서는 빌트인 모듈인 `functools`의 `lru_cache` 데코레이터를 사용해서 함수의 반환값들을 메모이제이션할 수 있다.
@lru_cache()
def fibo(n):
    return n if n < 2 else fibo(n-2) + fibo(n-1)

def Main():
    number = int(input("Enter integer: "))
    print(fibo(number))

if __name__=='__main__':
    Main()
```

---

***Reference***

[더 좋은 코드를 위한 함수형 프로그래밍](http://ndcreplay.nexon.com/NDC2017/sessions/NDC2017_0025.html)

[[Python] memoize](https://planbs.tistory.com/entry/Python-memoize)