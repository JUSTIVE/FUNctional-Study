# String in F#

### 1. String Literals
- String literals are delimited by the quotation (") 

|Character|Excape sequence|
|---|----|
|Backspace|\b|
|Newline|\n|
|Carriage return|\r|
|Tab|\t|
|Backslash|\\\\|
|Quotation|\\"|
|Apostrophe|\\'|
|Unicode character|\uXXXX or \UXXXXXXXX (X = hexadecimal digit)|

<br>

### 2. Ignoring the escape sequence
- Two ways makes the compiler ignoring the escape sequence
    - Using the @ symbol
    - Enclosing the string in triple quotes
- Verbatim string = a string literal is preceded by the @ symbol
    - All escape sequence are ignored, except two quotation mark characters that are interpreted as one quotation mark characters
- Code
```
    let str = @"<fruit name = ""Apple"" color = ""Apple color"">"
    printfn "%s" str
```
- Output
```
    <fruit name = "Apple" color = "Apple color">
```
<br>

### 3. Basic Operators
- collect
- concat
- exists
- forall
- init
- iter
- iteri
- length
- map
- mapi
- replicate

<br><br>

# Reference
https://www.tutorialspoint.com/fsharp/fsharp_strings.htm
