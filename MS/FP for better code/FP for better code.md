# 더 좋은 코드를 위한 함수형 프로그래밍

전이삭, Blizzard Entertainment, NDC 2017

- 순수함수와 불변성
- 고차함수와 함수의 합성
- 타입 시스템과 대수적 자료형
- 타입을 매개로 한 함수의 합성

## 순수 함수 Pure Functions

- 함수의 결과값이 오직 인자값에 의해서 결정
- 특정 입력 값에 대해서 결과값이 결정적으로 대응되는 함수
- 부작용이 없는 함수

### 부작용

모든 부작용은 상태와 관련이 있음

- 상태에 영향을 받거나 변화를 주는 모든 동작
- 화면 출력
- 소켓 통신
- 디스크 I/O
- try/catch
- 현재 시간 읽기
- 난수

> 그렇다면 왜 이렇게까지 상태를 없애고, 부작용을 없애려 하나?  
> ➡`참조 투명성 Referential Transparency`를 얻기 위해서

### 참조 투명성

어떤 함수 `f(x)` 에 대해 `x=1` 일때 `f(x) = 2` 임이 보장되면 프로그램 내의 모든 `f(1)`을 `2`로 교체할 수 있음

컴파일러가 프로그램을 최적화 할 여지가 생김

- `메모이제이션 memoization` 어떤 함수를 연산하는 데에 드는 일체의 비용을 절감할 수 있음
- `지연 연산 lazy evalutation` 함수와 인자를 실제 결과값이 필요한 순간까지 연산하지 않음

#### 지연 연산 lazy evaulation

<table>
  <tr>
    <td>언어</td>
    <td>지연 연산 여부</td>
    <td>코드</td>
    <td>비고</td>
  </tr>
  <tr>
    <td rowspan=2>Scala</td>
    <td>❌</td>
    <td>
    <pre lang="scala">
object main {
  def main(args:Array[String]):Unit ={
    val x = List(1,2,3,4,5)
    val y = x.map(l=>l*2)//이 시점에서 계산됨
    println(y)
  }
}
    </pre>
    </td>
    <td></td>
  </tr>
  <tr>
    <td>⭕</td>
    <td>
    <pre lang="scala">
object main {
  def main(args:Array[String]):Unit ={
    val x = List(1,2,3,4,5)
    lazy val y = x.map(l=>l*2)
    println(y)//이 시점에서 계산됨
  }
}
    </pre>
    </td>
    <td></td>
  </tr>
  <tr>
    <td rowspan=2>F#</td>
    <td>❌</td>
    <td>
    <pre lang="fsharp">
open System
[&ltEntryPoint&gt]
let main argv = 
  let x = [1;2;3;4;5]
  let y = x |> List.map(fun l -> l*2)//이 시점에서 계산됨
  printfn "%A" y.Force
  0
    </pre>
    </td>
    <td></td>
  </tr>
  <tr>
    <td>⭕</td>
    <td>
    <pre lang="fsharp">
open System
[&ltEntryPoint&gt]
let main argv = 
  let x = [1;2;3;4;5]
  let y = lazy(x |> List.map(fun l -> l*2))
  printfn "%A" y.Force//이 시점에서 계산됨
  0
    </pre>
    </td>
    <td></td>
  </tr>
</table>

##### Scala 에서의 지연 연산 처리
scala 에서는 매우 강력한 지연 연산이 수행되는 것으로 확인됨
```scala
object main {
  def main(args:Array[String]):Unit ={
    val x = {//lazy 키워드에 상관 없이
      println("print")
      234234
    }
    val w = x//이 시점에서 계산됨
    val w2 = x//이 값은 아예 계산이 되지 않음
  }
}
```
