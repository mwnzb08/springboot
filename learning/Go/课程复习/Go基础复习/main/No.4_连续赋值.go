package main

import "fmt"

//基础递增
func main() {
	const (
		a int = 1 + iota
		b
		c
	)
	fmt.Print(a, b, c)
	//二进制移位
	const (
		binary1 = 1 << iota //0001 = 1
		binary2             //0010 = 2
		binary3             //0100 = 4
	)
	fmt.Print(binary1, binary2, binary3)

}
