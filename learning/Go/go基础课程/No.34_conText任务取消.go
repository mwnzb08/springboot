package main
//使用No.33的改造
import (
	"context"
	"fmt"
	"time"
)

func main() {
	//chans是标记这个context的代任务。即是context.Background()的子
	//context.BackGround用来创建根context
	//当context.Background()被取消，那么所有的chans也会被取消
	chans,cancel:=context.WithCancel(context.Background())//创建一个子context
	rec3(chans,cancel)
	time.Sleep(time.Second*1)
}

func rec3(c context.Context, cancel func()) {
	for i := 0; i < 4; i++ {
		go func(i int,c context.Context) {
			for { //监听chan
				if isChans(c) {
					break
				}
			}
			fmt.Println(i,"is close")
		}(i,c)
	}
	//cancel()//调用方法取消全部的任务
}

func isChans(c context.Context) bool {
	select {
	case <-c.Done()://使用.Done（）来接收消息
		return true
	default:
		return false
	}
}
