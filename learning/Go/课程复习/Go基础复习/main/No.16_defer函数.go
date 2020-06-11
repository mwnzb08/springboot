package main

import "fmt"

func main() {
	//即使是panic后还是会执行
	defer func() {
		fmt.Println("hahaha")
	}()
	panic("error")//抛出错误
	fmt.Println("我想执行")
}
