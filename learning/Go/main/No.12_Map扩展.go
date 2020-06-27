package main

import "fmt"

func main() {
	// Map 的value 除了基础的值之外还可以是一个方法
	//即Map["hello"] = func() {}
	m:= map[string]func(op string)string{}
	m["hello"] = func(op string) string {
		return op
	}
	fmt.Println(m["hello"]("world"))
	delete(m,"hello")//删除

	//Go没有Set集合，实现Set集合map[type]bool{}





}
