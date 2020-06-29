package main

import (
	"errors"
	"fmt"
	"strconv"
	"time"
)

func main() {
	//使用chan当对象池存储可复用的数据
	pool:=setChan(9)//设置初始化的池的大小
	for i:=0;i<10 ;i++  {//获取10次
		if data,err:=pool.getChan(time.Second*1);err!=nil {
			fmt.Println(err)//当获取失败就打印error
		} else {
			fmt.Println(data)
			//if err1:= pool.Relases(data);err1!=nil {
			//	fmt.Println("err1")//当放满后还放就error
			//}
		}
	}
	//if err1:= pool.Relases("555");err1!=nil {
	//	fmt.Println(err1)//当放满后还放就error
	//}
}

type intNumber struct {
	bufChan chan string//int默认就是0.所以注意
}

func setChan(c int) *intNumber{
	b:=new(intNumber)
	b.bufChan = make(chan string,c)
	for i:=0;i<c;i++ {
		b.bufChan<-strconv.Itoa(i)
	}
	return b
}

func (e *intNumber) getChan(t time.Duration) (string,error){
	select {
	case ret:=<-e.bufChan:
		return ret,nil
	case <-time.After(t):
		return "error",errors.New("time out")
	}
}

func (e *intNumber) Relases(c string) error {
	select {
	case e.bufChan<-c:return nil
	default:
		return errors.New("over flow")

	}
}
