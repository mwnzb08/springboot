package main

import "fmt"

func main() {
	//数组的一种形式，可自增数组
	//声明方式
	var a []int
	//a[1] = 1 有专属的增加的函数，直接赋值当不存在index是不允许的
	a = append(a, 1)
	fmt.Println(a)
	a[0] = 3
	fmt.Println(a)
	//同样支持：=格式
	b:=[]int{}
	b = append(b, 1)
	fmt.Println(a)
	//可指定初始化长度的slice，使用make([]int , len, cap)长度，容量
	c:=make([]int , 3 ,5)
	c[1] = 1
	c = append(c, 2)
	c = append(c, 3)
	fmt.Println(c,cap(c))
	c = append(c, 6)//当超出cap容量，cap 1024以下直接*2
	fmt.Println(c,cap(c))
	//slice是共享的，改变其中的某一个片段的值，总的也会变化,
	//slice只能和nil比较
	d:= c[1:3]
	d[0] = 66
	fmt.Println(c,cap(d),len(d))//cap(d) = c[1-9]虽然只是截取了中间的一段，
	// 但是后面的也会计入cap

}
