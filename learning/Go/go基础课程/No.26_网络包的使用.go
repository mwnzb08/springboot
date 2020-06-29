package main

import (
	"fmt"
	cm "github.com/easierway/concurrent_map"
)
//go get -u  github.com/easierway/concurrent_map获取网络包
//注意一个package 只能有一个main方法，这里是把运行的选择在文件路劲
//而不是package,所以可以运行，go的目录是严格的
func main() {
	a:=cm.CreateConcurrentMap(99)
	a.Set(cm.StrKey("hello"),10)
	fmt.Println(a.Get(cm.StrKey("hello")))

}
