open System

type UnionFind(n: int) =
    let arr: array<int> = [|0..n-1|]

    member uf.find(x: int) =
        if arr.[x] = x then x
        else
            arr.[x] <- uf.find(arr.[x])
            arr.[x]
    
    member uf.query(s: int, t: int) =
        let mutable res: int = 0
        if uf.find(s) = uf.find(t) then
            res <- 1
        printfn "%d" res

    member uf.union(s: int, t: int) =
        let sID: int = uf.find(s)
        let tID: int = uf.find(t)
        if sID <> tID then
            arr.[sID] <- tID 

    member uf.move(s: int, t: int) =
        let sID: int = uf.find(s)
        let tID: int = uf.find(t)
        if sID <> tID then
            arr.[s] <- tID

let n, m = 
    let fln = Console.ReadLine().Split() |> Array.map int
    fln.[0], fln.[1]

let uf: UnionFind = UnionFind(n)

let ins = 
    [ for _ in 1..m do
        let ln = Console.ReadLine().Split() |> Array.map int
        ln.[0], ln.[1], ln.[2] ]

for i in ins do
    match i with
    | 0, s, t -> uf.query(s, t)
    | 1, s, t -> uf.union(s, t)
    | 2, s, t -> uf.move(s, t)
    | _ -> failwith "invalid instruction"