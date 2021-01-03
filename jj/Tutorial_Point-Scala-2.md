# Scala 기본 구문

- 스칼라와 자바의 가장 큰 구문의 차이 : ";"와 "return"는 선택사항. 리턴은 마지막줄을 리턴. 
- void 대신 Unit을 사용 

```scala
class math{
  def plus(one : Int, two : Int): Int ={
    one + two // 리턴
  }
}
object T{
  def main(args: Array[String]): Unit = {
    
  }
}
```

- Object - 싱글톤 객체, 정적으로 사용할 값들을 지정할 때 사용.

```scala
// 정적 객체를 선언. new 연산자로 동적 메모리 할당을 하지않음. "object 로 선언"

object A {
  def plus(one : Int, two : Int) : Int = one+two
}

object T {

  def main(args: Array[String]): Unit = {
    Console.println(A.plus(1,2)) // 결과는 3.
  }
}

```

- Class - 동적 객체. 메모리를 할당하는 객체라고 생각하면 편함 (?). "class 로 선언"

```scala
object A {
  def plus(one : Int, two : Int) : Int = one+two
}
class B{
  def plus(one : Int, two : Int) : Int = one+two
}
object T {

  def main(args: Array[String]): Unit = {
    Console.println(A.plus(1,2)) // 메모리 할당하지 않고 바로 사용 가능 
    // val a = new A() !==> 컴파일 에러
    val test = new B() // 메모리 할당
    Console.println(test.plus(1,2))
  }
}

```

- Method - 동작을 구현해놓은 구현체. 클래스 내에서 클래스와 관련된 실질적인 동작을 함. "def로 선언"

```scala
object T{
  def IMDEF() : Unit = Console.println("Hello Scala")
  def main(args: Array[String]): Unit = {
    IMDEF()
  }
}
```

- Fields - 고유한 인스턴스 변수의 집합들. 스칼라에서는 자동으로 타입을 추론함으로 명시적으로 타입을 선언할 필요 없음. 
    
    1. val - 상수 (Immutable - 수정 불가. )
    2. var - 변수 (Mutable - 수정 가능)
```scala
object T{
  def main(args: Array[String]): Unit = {
    val hello_immutable = "I hate Scala" // String
    var hello_mutable = "Hello Scala" // String
    var one = 1 // int
    // hello_immutable = "I like Scala" !==> 컴파일 에러!
    hello_mutable = "I like Scala" // !==> 정상 컴파일
  }
}
```

-Trait : 추상 클래스, 정의만 할 수도 있고, 구현 또한 가능하다. 두개 이상의 trait을 상속받고 싶다면 with를 통해 추상클래스를 믹싱할 수 있다.


```scala
trait student{
  def person(name : String, age : Int)
}
trait teacher{
  def person(name : String, age : Int, subject : String)
}
class A extends student with teacher{
  override def person(name: String, age: Int): Unit = ???
  override def person(name: String, age: Int, subject: String): Unit = ???
}
```

- case class - 인스턴스 생성시 new 연산을 통해 생성하지 않음.
케이스 클래스의 파라미터들은 불변 테이터이고, 각 파라미터는 "."연산자를 통해서 접근 가능.

```scala
trait Test
case class A(A : String, B : String) extends Test
case class B(A : String) extends Test
case class C(A : String, B : String, C : String) extends Test
object T{

  def main(args: Array[String]): Unit = {
    val a1 = A("A","B")
    val a2 = A("A","B")
    val a3 = A("A","C")
    Console.println("a1의 A는 " +a1.A+ "입니다.")
    if(a1 == a2){
      Console.println("a1 == a2")
    }
    else{
      Console.println("a1 != a2")
    }
    if(a1 == a3){
      Console.println("a1 == a3")
    }
    else{
      Console.println("a1 != a3")
    }
  }
}

// 출력
a1의 A는 A입니다.
a1 == a2
a1 != b

```

- match - 자바와 C언어의 switch case와 비슷하지만 더욱 강력한 기능을 제공

- 값들을 패턴 매칭

```scala
trait Test
case class A(A : String, B : String) extends Test
case class B(A : String) extends Test
case class C(A : String, B : String, C : String) extends Test
object T{

  def main(args: Array[String]): Unit = {
    val a1 = A("A","B")
    val a2 = A("A","B")
    val a3 = A("A","C")
    Console.println("a1의 A는 " +a1.A+ "입니다.")
    a1.A match {
      case "A" => Console.println("a1.A = A")
      case "B" => Console.println("a1.A = B")
      case "C" => Console.println("a1.A = C")
      case _ => Console.println("None")
    }
  }
}

// 출력 

a1의 A는 A입니다.
a1.A = A
```
- 케이스 클래스 매칭
```scala
trait Test
case class A(A : String, B : String) extends Test
case class B(A : String) extends Test
case class C(A : String, B : String, C : String) extends Test

object T{
  def TTT(test: Test):Unit ={
    test match {
      case A("A","B") => Console.println("This is A1")
      case A("A","C") => Console.println("This is A3")
      case B("A") => Console.println("This is B1")
      case C(_,_,_)=>Console.println("This is C1")
      case _ => Console.println("None")
    }
  }
  def main(args: Array[String]): Unit = {
    val a1 = A("A","B")
    val a2 = A("A","B")
    val a3 = A("A","C")
    val c = C("A","B","C")
    TTT(c)
    TTT(a1)
    TTT(a2)
    TTT(a3)
  }
}

// 출력 
This is C1
This is A1
This is A1
This is A3
```