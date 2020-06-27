package main

import "fmt"

func main() {
	//go中指针和示例都可以访问，推荐使用指针/因为使用实例会把数据复制一份，
	//性能就会降低。
	a:= eg{1,"mo",25}
	fmt.Println(a.Strings())
	//Strings() 并不是公用的方法

}
//struct 结构的书写
type eg struct {
	id int
	name string
	age int
}
//可以理解为前面（e *eg）的方法函数Strings（）。
func (e *eg) Strings() string {
	return e.name//可以直接访问，和实例是一样的
}
