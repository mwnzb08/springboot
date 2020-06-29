package main

import (
	"fmt"
	"math"
)

func main() {
	//基本数据类型包括 8 种
	//bool int uint float string byte rune complex
	//不支持隐式转换int32 转 int64 都不可以, 别名也不可以
	fmt.Println(math.MaxInt8) //获取类型最大数

	//go 不支持指针运算
	a := 1
	aptr := &a
	//aptr = aptr + 1
	fmt.Printf("%T,%T,%v", a, aptr, aptr)

	//string 字符类型，未赋值则是"",不是nil（空）
	var s string
	fmt.Println("")
	fmt.Println(">" + s + "<")
	fmt.Print("s>>", len(s))

}
