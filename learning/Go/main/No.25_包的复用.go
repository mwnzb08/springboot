package main

import "fmt"

func init() {//会在执行main之前执行
	fmt.Println("hello")
}

func init() {//可以包含多个
	fmt.Println("world")
}
func main()  {
fblq()
}
//创建一个package 编写一个费布拉切数列。然后其他地方调用
//首字母大写的才能给包外访问不然只能在包内访问,详细请看testPackage
// 自定义使用slice 完成数列
func fblq() {
	var s= []int{}
	s = append(s, 1)
	s = append(s, 1)
	for i:=0;i<5 ;i++  {
		s = append(s, s[i] + s[i+1])
	}
	fmt.Println(s)
}

func Fblq() {
	var s= []int{}
	s = append(s, 1)
	s = append(s, 1)
	for i:=0;i<5 ;i++  {
		s = append(s, s[i] + s[i+1])
	}
	fmt.Println(s)
}

