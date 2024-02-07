open System

type CoffeeCupCombo(n: int, chars: char[]) =
    let n: int = n
    let arr: char[] = chars

    member this.maxLectures(): int =
        let mutable max: int = 0                    // keep track of the max and coffee count
        let mutable c: int = 0
        for i in 0..n-1 do
            if arr.[i] = '0' then
                if c > 0 then
                    max <- max + 1                  // increment maxCount
                    c <- c - 1                      // consume 1 cup of coffee
            else
                max <- max + 1                      // increment maxCount
                c <- 2                              // bring lots of coffee
        max

let n: int = Console.ReadLine() |> int
let chars: char[] = Console.ReadLine().ToCharArray()
let ccbo: CoffeeCupCombo = CoffeeCupCombo(n, chars)
printfn "%d" (ccbo.maxLectures())