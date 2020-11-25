# Data Types in F#

### 1. Integral Data Type
|F# Type|Size|Range|Example|Remarks|
|---|---|---|---|---|
|sbyte|1 byte|-128 to 127|42y, -11y|8-bit signed integer|
|byte|1 byte|0 to 255|42uy|8-bit unsigned integer|
|int16|2 bytes|-32768 to 32767|42s|16-bit signed integer|
|uint16|2 bytes|0 to 65535|42us|16-bit unsigned integer|
|int/int32|4 bytes|-2,147,483,648 to 2,147,483,647|42|32-bit signed integer|
|uint32|4 bytes|0 to 4,294,967,295|42u|32-bit unsigned integer|
|int64| 8 bytes|-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807|42L|64-bit signed integer|
|uint64|8 bytes|0 to 18,446,744,073,709,551,615|42UL|64-bit unsigned integer|
|bigint|At least 4 bytes|any integer|42I|arbitrary precision integer|

<br><br>

### 2. Floating Point Data Type
|F# Type|Size|Range|Example|Remarks|
|---|---|---|---|---|
|float32|4 bytes|±1.5e-45 to ±3.4e38|42.0F|32-bit signed floating point number (7 significant digits)|
|float|8 bytes|±5.0e-324 to ±1.7e308|42.0|64-bit signed floating point number (15-16 significant digits)|
|decimal|16 bytes|±1.0e-28 to ±7.9e28|42.0M|128-bit signed floating point number (28-29 significant digits)|
|BigRational|At least 4 bytes|Any rational number|42N|Arbitrary precision rational number (requires a reference to FSharp.PowerPack.dll.)|

<br><br>

### 3. Text Data Type
|F# Type|Size|Range|Example|Remarks|
|---|---|---|---|---|
|char|2 bytes|U+0000 to U+ffff|'x', '\t'|Single unicode characters|
|string|20 + (2 * string's length) bytes|0 to about 2 billion characters|"Hello"|Unicode text|

<br><br>

### 4. Other Data Type
|F# Type|Size|Range|Example|Remarks|
|---|---|---|---|---|
|bool|1 byte|Only two possible values, true or false|true / false|Stores boolean values|

<br><br>

# Reference
https://www.tutorialspoint.com/fsharp/fsharp_data_types.htm
