package main

import "fmt"
//自定义可以简化一些函数，例如把前面的计时器简化
func main() {
a:=personal(op)
fmt.Println(a(5))
}

type ints int
type funcs func(op int) int

func personal(ops funcs) funcs {
	return funcs(ops)
}

func op(op int) int {
	return op
}
