package main

import "fmt"

func main() {
	var (
		a int = 1
		b int = 2
	)
	a, b = b, a
	fmt.Print(a, b)
}
