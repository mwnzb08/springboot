package main

import "fmt"

//slice 切片，顾名思义类似一个builder。有序
func main() {
	//创建一个空切片
	s:=[]int {}
	//创建一个有起始位置的切片
	ss:=make([]int,2)
	//创建一个有值的切片
	//          0 1 2 3
	sss:=[]int {1,2,3,4}
	for i:=0;i<2048 ;i++  {
		s=append(s,i)
		fmt.Println(len(s),cap(s))//查看随着切片的数值的增加，相应的容量增加情况
	}//这里看到是有规律的增加的,一定范围内X2，超过一个范围增加1/4.源码这样的，自己可以修改有实力。
	ss = append(ss, 10,20)//由于起始位置是2，这里从第三个开始加数据
	fmt.Println(ss)

	a:=sss[1:3]//这里我们可以知道按照0起位截取切片的时候包括起始数值，但是不包括结尾数值。
	fmt.Println(a)
	a[0] = 999
	fmt.Println(sss,a)//截取部分发生变化，总的也会发生变化。共享一个内存数据。
}
