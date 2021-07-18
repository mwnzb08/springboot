package main

import (
	"fmt"
	"time"
)
//选择等待，当time2ss能取出chan的时候执行返回successful
//否则超过1秒之后执行返回time out 用于超时控制，防止死锁
//当设置的时间时相同的时候看运气咯，谁会先执行完,所以哪怕是1ms也要注意到要小于超时时间
func main() {
	//a:=<-time2ss()
	//fmt.Println(a)
	select {
	case a:=<-time2ss(): fmt.Println("successful",a)
	case <-time.After(time.Second*2): fmt.Println("time out")
	}

}

func time2ss() chan string{
	chans :=make(chan string)
	go func() {
		time.Sleep(time.Second*3)
		chans<-"1"
		fmt.Println("2sssss")
	}()
	return chans
}
