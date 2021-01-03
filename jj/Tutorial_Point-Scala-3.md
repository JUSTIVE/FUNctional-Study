# Scala 기본 구문

- Closures : 반환값이 함수 외부에 선언되어있는 하나 이상의 변수의 값에 의존하는 함수

```
object T{
  def main(args: Array[String]): Unit = {
    val one = 1
    var oneplus = (two : Int) => one + two
    Console.println(oneplus(1))
  }
}

// 출력 
2
```

- 배열 선언 (다차원 배열을 직접 지원하지 않으며, 다른 방법을 사용하려면 Array._ 패키지를 가져와야함.)

```
object T{
  def main(args: Array[String]): Unit = {
    var array = Array(1,2,3,4,5) // 배열 선언
    array.foreach(x=>Console.println(x))
  }
}

// 출력
1
2
3
4
5

```
- 다차원 배열 선언
```

object T{
  def main(args: Array[String]): Unit = {
    var arrays_2 = Array.ofDim[Int](2,2)
    arrays_2(0)(0) = 1
    arrays_2(0)(1) = 2
    var i = 1
    arrays_2.foreach(x=>{

      Console.println(i +"dim")
      x.foreach(y=>Console.println(y))
      i = i + 1
    })
  }
}

// 출력

1dim
1
2
2dim
0
0

```

- 정규식 : String 문자열을 ".r" 해줌으로써 정규표현식으로 전환 가능

```

object T{
  def main(args: Array[String]): Unit = {
    var regex = "\\d+-\\d+-\\d+".r
    Console.println(regex.findAllIn("정지석 전화번호 : 010-4013-1378, 홍길동 전화번호 : 019-1111-1111").mkString(","))
  }
}

// 출력 

010-4013-1378,019-1111-1111
```

- 예외 처리 : 패턴 매칭하여 예외처리

```
import java.io.{FileNotFoundException, FileReader}
import scala.reflect.io.File

object T{
  def main(args: Array[String]): Unit = {

    try{
      var file = new FileReader("a.txt")
    }
    catch {
      case ex : FileNotFoundException=>{
        Console.println("파일이 없음")
      }
      case ex : Exception=>{
        Console.println("이런식으로 패턴매칭해서 예외처리 가능")
      }
    }

  }
}

```

- 꼬리 재귀 : @tailrec 어노테이션을 사용

- tailrec 사용 하지 않음. 꼬리재귀 형식이 아니기 때문에 @tailrec 사용시 컴파일 에러

```

class math{
  def fectorial(num : Int) : Int = {
    
    if (num <= 1) num
    else num * fectorial(num-1)
  }
}
object T{
  def main(args: Array[String]): Unit = {
    val a = new math();
    Console.println(a.fectorial(5))
  }
}

// 콜 스택
(fact 5)
(* 5 (fact 4))
(* 5 (* 4 (fact 3)))
(* 5 (* 4 (* 3 (fact 2))))
(* 5 (* 4 (* 3 (* 2 (fact 1)))))
(* 5 (* 4 (* 3 (* 2 (* 1 (fact 0))))))
(* 5 (* 4 (* 3 (* 2 (* 1 * 1)))))
(* 5 (* 4 (* 3 (* 2))))
(* 5 (* 4 (* 6)))
(* 5 (* 24))
120
```
- 꼬리 재귀 사용
```
class math{
  def fectorial(num : Int) : Int = {
    @tailrec
    def _fectorial (num : Int, result : Int) : Int ={
      if(num <= 1) result
      else{
        _fectorial(num - 1, result * num)
      }
    }
    _fectorial(num, 1)
  }
}
object T{
  def main(args: Array[String]): Unit = {
    val a = new math();
    Console.println(a.fectorial(5))
  }
}

// 콜스택
(fact_with_tailrec 5)
(fact_inside 5 1)
(fact_inside 4 5)
(fact_inside 3 20)
(fact_inside 2 60)
(fact_inside 1 120)

```