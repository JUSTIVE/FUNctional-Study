open System

[<EntryPoint>]
let main argv = 
    let rec getResult n cnt (x:bigint) (y:bigint) =
        if cnt=n then (x+y)*(new Numerics.BigInteger(2))
        else if x > y then getResult n (cnt+1) x (x+y)
        else getResult n (cnt+1) (x+y) y

    let getRes n =
        getResult n 1 (new Numerics.BigInteger(1)) (new Numerics.BigInteger(1))

    Console.ReadLine() |> Convert.ToInt32 |> getRes |> printfn "%A"

    0 // return an integer exit code
