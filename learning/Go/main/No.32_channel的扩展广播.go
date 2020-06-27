package main

import (
	"fmt"
	"runtime"
	"sync"
	"time"
)

func main() {
	fmt.Println("before",runtime.NumGoroutine())
	w:=new(sync.WaitGroup)
	chans:=make(chan int)
	pro(chans,w)
	rec(chans,w)
	w.Wait()
	fmt.Println("finally",runtime.NumGoroutine())
}
//pro提供消息，rec消费消息，当pro提供了4个消息，有无数rec的时候能正常结束
//发完之后close（c）接受的判断没有信息就中断了，
//当发的多，接的少的时候，发送方会被阻塞。？如何解决这个问题？
//当其他地方关闭chan 发送方如何知晓。死循环。recover可以使用
func pro(c chan int, group *sync.WaitGroup) {
	cc:=make(chan int)
		go func () {
			defer func() {
				if err:=recover();err!=nil {
					fmt.Println("chan read close")
				}
			}()
			for a:=0;a<4;a++ {//发送4条
				c <- a+1
			}
			fmt.Println("ok for send")//发完显示
			cc<-1
			close(c)
		}()
		group.Add(1)
		go func() {//启动一个select选择，监听结束的chan，当超时没有返回就关闭chan并打印
			select {
			case <-time.After(time.Second*1):close(c);fmt.Println("time out")
			case x:=<-cc:fmt.Println("successful",x);close(cc)
			}
			group.Done()
		}()
}

func rec(c chan int, group *sync.WaitGroup) {
	for x:=0;x<3;x++{//只接收3条//改为for就是无数的接受，当close就会中断
		if data,ok:=<-c;ok {
			group.Add(1)
			go func(data int) {
					fmt.Println(data)
				group.Done()
			}(data)
		}else {
			break
		}
	}
}
