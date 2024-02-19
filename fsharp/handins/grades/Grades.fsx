open System

let toInt s =
    match s with
    | "A" -> 7
    | "B" -> 6
    | "C" -> 5
    | "D" -> 4
    | "E" -> 3
    | "FX" -> 2
    | "F" -> 1
    | _ -> failwith "invalid grade"

let toTriple(s: string) =
    let a: string[] = s.Split()
    let b: string[] = a.[1].Split([|'+'; '-'|], 2)
    let m =
        if b.Length > 1 then
            if b.[1].Contains("+") then b.[1].Length + 1    // sloppy.. but works
            else -(b.[1].Length + 1)
        else 0
    (a.[0], toInt b.[0], m)

let less(a: (string * int * int), b: (string * int * int)) =
    

let merge(
    a: (string * int * int)[],
    l: int, m: int, r: int) =
    let mutable i = l
    let mutable j = m+1
    let mutable k = l
    let aux = Array.copy(a)
    while k <= r do
        if i > m then
            a.[k] <- aux.[k]
            k <- k + 1
        elif j > r then
            a.[k] <- aux.[i]
            i <- i + 1
        elif 

let rec sort(a: (string * int * int)[], l: int, r: int) =
    if a.Length = 1 then return
    else
        if r <= l then return
        else
            let m = l + (r-1) / 2
            sort(a, l, m)
            sort(a, m+1, r)
            merge(a, l, m, r)

let n = Console.ReadLine() |> int
let a = [|
    for i in 0..n-1 do
        toTriple(Console.ReadLine())
|]

sort(a, 0, a.Length-1)
Seq.iter (fun (s, _, _) -> printfn "%s" s) a