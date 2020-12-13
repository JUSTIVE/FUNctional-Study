## 불변성 - Immutability

간단히 `상태를 변경하지 않는 것`이라고 정의할 수 있다.

프로그래밍의 개념에선 무언가를 저장하고 변경하고 불러오는 상태라는 개념이 존재하지만, 수학에선 그러한 개념이 없으며 수학의 함수를 프로그래밍으로 구현한 순수함수 역시 함수 외부의 무언가에 영향을 받지 않고  독립적으로 존재해야 한다.

여기서 말하는 `상태의 변경`이란 단순한 변수의 재할당만을 이야기하는 것이 아니다. 정확히 말하면 메모리에 저장된 값을 변경하는 모든 행위를 의미하며, 여기에 변수의 재할당과 같은 행위도 포함되는 것이다.

## 변수를 통해 메모리에 접근한다.

우리는 변수를 선언하고 선언한 변수에 값을 할당한다.

```javascript
let a;
a = 1;
console.log(a);
```
우리는 `a`라는 변수를 할당하고 `1`이라는 값을 `a`변수에 할당했다.

`a`변수를 선언하면 메모리에 해당 변수로 접근할 수 있는 메모리 공간을 마련한다. 이때 곧바로 `a`변수에 접근하면 "아무것도 정의되지 않은"의미의 `undefined`를 볼수 있다.

그 후 `a = 1`이라는 명령을 통해 마련된 메모리 공간에 `1`이라는 값을 저장했고, 이제 `a`라는 변수를 통해 우리는 해당 메모리 공간에 저장되어 있는 `1`이라는 값을 얻어낼 수 있게 된다.

만약 `a = 2`처럼 해당 변수의 값을 다시 할당한다면 해당 메모리공간에 저장된 값을 변경하는 것으로 상태를 변경하는 행위라고 말할 수 있다.

## 불변객체의 특징
- 내용의 변경은 새로운 객체를 생성할 때만 가능하다.
- 생성하는 시점의 그 객체에 대한 모든 정보를 알아야 만들수 있기 때문에 생성자만 보면 해당 객체를 파악하기 쉬워진다.
- `readonly`이기 때문에 `Thread-safe`한 속성을 가지고 있다.
- 쉬운 캐쉬: 내용이 변하지 않기 때문에 해당 객체의 이름만 알아도 굳이 내용을 비교할 필요가 없음
- `Temporal coupling` 줄임
- `Identity mutability problem` 없음

## Temporal coupling - 일시적 결합

`Temporal coupling(일시적 결합)`은 두 개의 프로세스가 동시에 발생해서 하나의 모듈에 묶이는 경우를 말한다.

불변객체로 구현할 경우 생성할 때 모든 정보를 제공해야 하기 때문에 반드시 유효한 동작을 할 수 있도록 보장된다.

```python
import requests

class HttpRequest:
    def __init__(self, url, param):
        self.url = url
        self.param = param

    def post(self):
        res = requests.post(url=self.url, data=self.param)
        return res.json()

params = {'code': 200, 'text': 'test Text'}

req = HttpRequest('http://httpbin.org/post', params)
print(req.post())
```

## Identity mutability problem - 정체성에 대한 문제



## 메모리, disk, cpu

불변객체를 쓰기 위해서 매번 객체를 새로 생성하면 메모리가 너무 낭비가 아닌가 하는 생각이 들 수도 있으나

메모리와 디스크의 가격은 시간이 지날수록 낮아지는데 CPU의 클럭 속도는 약 2005년을 기점으로 물리적인 한계에 봉착하여 속도의 개선보단 물리적인 코어의 개수를 늘리는 방향으로 성능향상을 이루고 있다.

순수함수는 상태를 가지지 않고 불변객체는 `Thread-safe`하기 때문에 주목을 받고 있는 이유이다.

## FP 실천사항 #2 - 불변객체
- 사용하는 객체를 불변으로 일단 바꾸어 놓고 코드를 고쳐보자
  - Setter들 대신에 생성자에서 인자로 초기화
  - 객체를 변경하지 않는 멤버함수들은 const로
- 다양한 분산 빅데이터 알고리즘들을 조사해보자
  - Immutability changes everything
- 영속형 자료 구조에 대해서 알아보자


***Reference***

[더 좋은 코드를 위한 함수형 프로그래밍](http://ndcreplay.nexon.com/NDC2017/sessions/NDC2017_0025.html)

[변하지 않는 상태를 유지하는 방법, 불변성(Immutable)](https://evan-moon.github.io/2020/01/05/what-is-immutable/)
