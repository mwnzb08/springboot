package main

import (
	"fmt"
	"sync"
	"time"
)

//而要想顺序得到保证，n那么就需要没人协程都加锁，运行完一个才能运行另一个
//反而会不好，所以看需要时不时要顺序得到保证
func main() {
	t:=time.Now()
//创建锁
a:= new(sync.Mutex)
//这个写法没有考虑意外无法执行导致锁不能释放，改造下
//	for i:=0;i<1000 ;i++  {
//		a.Lock()//执行前加锁
//		go func(i int) {
//			fmt.Println(i)
//			a.Unlock()//解锁
//		}(i)
//	}
//	使用defer保证锁的释放
b:=0
	for i:=0;i<500000 ;i++  {
		//a.Lock()//执行前加锁能保证运行完，但是性能不足
		go func(i int) {
			defer func() {a.Unlock()}()
			//a.Unlock()//解锁
			a.Lock()//锁，性能会高点，但是无法保证全部运行完主程序才结束
			b++
		}(i)
	}
	//for i:=0;i<1000 ;i++  {
	//		fmt.Println(i)
	//}//无锁用时2ms左右，所以需要锁很耗哦
	fmt.Println(b)
	fmt.Println(time.Since(t))//有锁用时3ms左右
}
