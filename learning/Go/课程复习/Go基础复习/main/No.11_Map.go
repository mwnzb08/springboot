package main

import "fmt"

func main() {
	//声明方式 map[key类型]value类型
	var a map[string]int
	b:= map[string]int{}
	c:= make(map[string]int,10)
	//a["hello"] = 5//这种类型的声明不能直接这样赋值。
	//fmt.Println(a)
	b["hello1"] = 5
	c["hello2"] = 5
	//a = b//但是可以接收
	fmt.Println(a,b,c)
	//注意value int在不赋值的情况下是0 需要主动的判断是否是初始的0.还是后来赋值上去的0
	if _,v:=a["hello"];v {
		fmt.Println("key")
	} else {
		fmt.Println("not key")
	}
}
