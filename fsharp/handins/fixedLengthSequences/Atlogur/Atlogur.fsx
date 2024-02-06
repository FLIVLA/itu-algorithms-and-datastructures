open System

type Atlogur(n: int, h: int[], s: int[]) =
    member this.beginBattles() =
        let mutable i: int = 0
        let mutable j: int = 1
        while j < n do
            this.battle(i, j)
            if h.[j] > h.[i] then
                i <- j
                j <- j + 1
            else j <- j + 1
        let w =
            if h.[i] > 0 then
                i + 1
            else
                j + 1
        printfn "%d" w

    member this.battle(i: int, j: int) =
        h.[j] <- h.[j] - s.[i]
        if h[j] > 0 then
            this.battle(j, i)
        
let n: int = Console.ReadLine() |> int
let h: int[] = Array.zeroCreate(n)
let s: int[] = Array.zeroCreate(n)

for i in 0..n-1 do
    let ln = Console.ReadLine().Split() |> Array.map int
    h.[i] <- ln.[0]
    s.[i] <- ln.[1]

let atl: Atlogur = Atlogur(n, h, s)
atl.beginBattles()