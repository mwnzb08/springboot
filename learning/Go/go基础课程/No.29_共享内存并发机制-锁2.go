package main

import (
	"fmt"
	"sync"
	"time"
)

//更多的使用sync.waitGroup来保证程序运行完才结束主程序
func main() {
	a:=time.Now()
	b:=new(sync.WaitGroup)
	d:= new(sync.RWMutex)
	c:=0
	for i:=0;i<100 ;i++  {
		b.Add(1)//增加一个
		go func() {
			defer func() {d.Unlock()}()
			d.Lock()
			c++
			b.Done()
		}()
	}
	b.Wait()//前面的协程不运行完不会给通过,不加锁计数还是会存在问题。不完全执行
	//通过两个的共同作用可以实现正确知晓协程是否运行完,
	//就是如果不加锁得到的结果等半年可能还是c也不正确
	fmt.Println(c)
	fmt.Println(time.Since(a))
}
