package main

import (
	"fmt"
	"time"
)

func main() {
//启动协想、程仅仅只是在执行的语句前面增加个go//并发之后顺序就得不到保证了
//	for i:=0;i<1000 ;i++  {
//		go func(i int) {
//			fmt.Println(i)
//		}(i)
//	}
	for i:=0;i<1000 ;i++  {
		go fmt.Println(i)
	}
//main执行玩了可能其他还没有执行完，所以可能不会有输出，需要等待一下
time.Sleep(1000)
}

