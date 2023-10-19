package main

import "fmt"
import "time"

func main() {
    p := fmt.Println

    present := time.Now()// current time
    p(present)

    DOB := time.Date(1993, 02, 28, 9,04,39,213 ,time.Local)
    fmt.Println(DOB)

    fmt.Println(DOB.Year())
    fmt.Println(DOB.Month())
    fmt.Println(DOB.Day())
    fmt.Println(DOB.Hour())
    fmt.Println(DOB.Minute())
    fmt.Println(DOB.Second())
    fmt.Println(DOB.Nanosecond())
    fmt.Println(DOB.Location())

    fmt.Println(DOB.Weekday())

    fmt.Println(DOB.Before(present))
    fmt.Println(DOB.After(present))
    fmt.Println(DOB.Equal(present))

    diff := present.Sub(DOB)
    fmt.Println(diff)
    fmt.Println(diff.Hours())
    fmt.Println(diff.Minutes())
    fmt.Println(diff.Seconds())
    fmt.Println(diff.Nanoseconds())
    fmt.Println(DOB.Add(diff))
    fmt.Println(DOB.Add(-diff))
}