open System

type Zoom(n: int, k: int, x: int[]) =
    let n: int = n
    let k: int = k
    let x: int[] = x
 
    member this.display() =
        let res =
            [ k-1..k..n-1]                            // generates sequence k-1..n-1 incrementing by k
            |> List.map (fun i -> x.[i])        // map over x and extract the elements
            |> List.map string                       // convert each element to string
            |> String.concat " "            
        printfn "%s" (res.Trim())                   // print hele molitjavsen

let fln: int[] = Console.ReadLine().Split() |> Array.map int
let z = Zoom(fln.[0], fln.[1], Console.ReadLine().Split() |> Array.map int)
z.display()