package main

import (
	"fmt"
)

//和例子NO.32比较类同，使用chan当任务取消
func main() {
	chans:=make(chan int)
	rec2(chans)
}

func chansInt(c chan int) {
	c<-1//只有一个会返回true
}

func rec2(c chan int) {
	for i := 0; i < 4; i++ {
		go func(i int,c chan int) {
			for { //监听chan
				if isChan(c) {
					break
				}
			}
			fmt.Println(i,"is close")
		}(i,c)
	}
	chansInt(c)
}

func isChan(c chan int) bool {
	select {
	case <-c:
		return true
	default:
		return false
	}
}
