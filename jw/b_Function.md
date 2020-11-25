# Function in F#

### 1. Recursion
- Code 
```
let rec recursiveFunction1 xs =
    match xs with 
    |[] -> 0
    |y::ys -> y + RecursiveFunction1 ys

let rec recursiveFunction2 xs result =
    match xs with
    |[] -> result
    |y::ys -> RecursiveFunction2 ys (y+result)

let intList = [1;2;3;4;5]

printfn "RecursiveFunction1 result : %d" recursiveFunction1 intList
printfn "RecursiveFunction2 result : %d" recursiveFunction1 intList 0
```
- Result
```
RecursiveFunction1 result : 15
RecursiveFunction2 result : 15
```
<br>

### 2. Higher Order Functions
- Code 
```
let func1 x = x+1
let func2 x = x*2
let func3 x = func1 (func2 x)

printfn "%d" (func3 1)
```
- Result
```
3
```
<br>

### 3. Polymorphism
- Advantage
    - Reuse the codes, save time
    - Single variable can store multiple data types
    - Easy to debug
- Code 
```

```
- Result
```

```
<br><br>

# Reference
https://www.tutorialspoint.com/functional_programming/index.htm
<br>
https://try.fsharp.org/
