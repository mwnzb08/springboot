package main

import "fmt"

func main() {
	var a int = 1
	var b int = 1
	fmt.Print(a, b)
	fmt.Print(" ")
	for c := 0; c < 10; c++ {
		d := b + a //a+b
		a = b      // a=b
		b = d      // b = d
		fmt.Print(d, " ")
	}

}
