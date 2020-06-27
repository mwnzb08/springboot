package main

import (
	"fmt"
	"time"
)
//chan 的机制。可以实现异步，当需要等待的时候执行另一个程序，当需要获取的时候
//监听有返回就获取，没有就等待，可以减少耗时。
func main() {
	t:=time.Now()
	chans:=time1s()
	time2s()
	fmt.Println(<-chans)//取出channel 如果没有取出会一直阻塞在这里
	fmt.Println(time.Since(t))//没有启动协程按顺序要3s,现在2秒也可以达到相同的效果
}

func time1s() chan string{
	chans:=make(chan string, 1)//可以设置容量来达到不阻塞chans<-的阻塞，防止没人接收一直阻塞
	go func() {
		time.Sleep(time.Second*2)
		chans<-"hello"//存入channel 如果没有来拿会一直阻塞在这里
		fmt.Println("1sssss")//没有设值容量会最后才执行。
	}()
	return chans
}

func time2s() {
	time.Sleep(time.Second*1)
	fmt.Println("2sssss")
}
