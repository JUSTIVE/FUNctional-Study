## 재귀
함수 본문에서 자기자신을 호출하는 방식을 `재귀호출(recursive call)`이라고 부른다. 재귀는 다른 명령어가 방지할 때까지 계속된다.

## 예제

### python
```python
def fact(n):
   if n == 1:
      return n
   else:
      return n * fact(n-1)

num = int(input("Enter a number: "))

if num < 0:
    print("Sorry, factorial does not exist for negative numbers")
else:
    print("The factorial of " + str(num) + " is " + str(fact(num)))


# Enter a number: 10
# The factorial of 10 is 3628800
```

---

## 꼬리 재귀 최적화 in python
재귀호출의 경우 호출 스택의 깊이가 얕은 경우엔 큰 상관이 없으나 깊이가 깊어지면 오버플로우가 발생하는 문제가 있다.
_여담으로 실행하는 ~~시스템에 따라서 조금씩 다를수 있지만~~ 파이썬에서 호출가능한 스택의 최대 깊이는 보통 1000 정도에서 `RecursionError`가 발생한다._

```python
def recurse(n):
    print(n)
    recurse(n+1)

recurse(1)

# 995
# 996
# Traceback (most recent call last):
# RecursionError: maximum recursion depth exceeded while calling a Python object
```

이를 해결하기 위한 방법으로 제시되는 해결책 중 하나가 꼬리 재귀`Tail recursion`이다.

간단히 말하자면 함수에서 마지막으로 호출하는 함수가 자기 자신이고, 재귀 호출의 값을 반환받은후 추가적인 연산이 필요하지 않는 방식을 말한다.

---

## 꼬리 재귀 적용 예제

위의 예제에서 사용한 팩토리얼 함수를 보자.

fact(n)을 호출했을 때 연산이 끝나지 않았는데 fact(n-1)을 호출하기 때문에 리턴 주소를 저장하기 위해서 시스템 콜스택을 사용하게 된다.

즉, 현재 함수(fact(n))에서 결과값을 반환하기 위해서는 현재 함수의 인자 값(n)을 스택에 가지고 있다가 그 다음 호출될 함수(fact(n-1))의 결과 값과 함께 연산을 해야 한다는 점이다.
이러한 방식은 꼬리 재귀를 만족하지 못한다고 본다.

예제를 꼬리 재귀로 바꾸려면 어떻게 해야할까? 재귀를 호출하는 부분에서 추가적인 연산이 필요없도록 만들면 되는데

이를 구현하기 위해선
> return에서는 *(언어 스펙에서 지정한 스택에 메모리를 쌓지 않는 연산자를 제외한)* 연산자를 사용하면 안된다.

연산자의 사용없이 재귀 호출의 반환값을 그대로 return 해주면 된다.

```python
def fact(n, result=1):
   if n == 1:
      return result
   else:
      return fact(n-1, n*result)
```
---

***Reference***

[tutorialspoint - Learn Functional Programming](https://www.tutorialspoint.com/functional_programming/functional_programming_recursion.htm)

[재귀,반복, Tail Recursion](https://homoefficio.github.io/2015/07/27/%EC%9E%AC%EA%B7%80-%EB%B0%98%EB%B3%B5-Tail-Recursion/)