package main

import (
	"fmt"
	"sync"
)

func main() {
//sync.Pool 在下一次Gc会被清空，所以实际上不属于持久的对象池。
	p:=new(sync.Pool)
	p.New = func () interface{} {//当没有找到的时候会使用new创建一个
	fmt.Println("create a new")
	return 1000
	}
	p.Put(1)
	//runtime.GC()//Gc之后清空，不适合做连接池
	fmt.Println(p.Get().(int))//断言取值是int 类型。
	fmt.Println(p.Get().(int))

}
