package main

import (
	"fmt"
	"time"
)

func main() {
	//go 的函数可以返回不仅仅是基本数据类型，还可以是另一个函数
	//slow(5)
	ss:=timeSpent(slow,"slow")//因为是传进去一个函数，所以不能直接传值.
	ss(5)//执行
	}

	func timeSpent(inner func(op int) int, name string) func(op int) int{
		return func(n int) int{
			start:=time.Now()
			hanshu:=inner(n)
			fmt.Println(name+ " timeSpent: ", time.Since(start).Seconds())
			return hanshu
		}
	}

	func slow(op int) int {
		time.Sleep(time.Second*2)
		return op
	}
