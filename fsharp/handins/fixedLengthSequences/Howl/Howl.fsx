open System

type Howl(h: string) =
    let n: int = h.Length + 1
    let H: string = ""

    member this.superAwesomeHowl(): string =
        let lim: int = n - 3
        let mutable next: char = 'A'
        let fp: char list = 
            [0..lim-1]
            |> List.map (fun _ ->
                let cur = next
                next <- if next = 'A' then 'W' else 'A'
                cur)
        let sp: char list = List.replicate (n - lim - 1) 'O'
        let res: char list = List.append fp ['H'] @ sp
        String(res |> List.toArray)

let h = Console.ReadLine()
let howl = Howl(h)
printfn "%s" (howl.superAwesomeHowl())

