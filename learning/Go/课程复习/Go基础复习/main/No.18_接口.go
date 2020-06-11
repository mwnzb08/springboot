package main

import "fmt"
func main() {
	//var a egInterface//定义接口
	a := new(egStruct)//绑定实例
	fmt.Println(a.hellos())//默认的命名一致就是同一个方法。
	//如果没有方法会报错，即interface 没有实例化不能调用
}

type egInterface interface {
	hellos() string
	//hello() string
}

type egStruct struct {

}

func (e *egStruct) hellos() string {
	return "hello"
}

//func (e *egStruct) hello() string {
//	return "hello2"
//}
