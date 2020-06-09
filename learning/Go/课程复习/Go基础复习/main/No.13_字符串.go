package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	// rune 获取16进制字符串
	//%x 16 进制
	var name string
	name= "莫"
	fmt.Printf("%x",name)//获取utf8
	unicodeName := []rune(name)
	fmt.Println(unicodeName)//%d
	fmt.Printf("%x",unicodeName)// 获取unicode
	b:= "\xE8\x8E\xAB"//莫的编码byte
	fmt.Println(b)
	//字符串分割拼接
	s:="a,b,c,d"
	ss:=strings.Split(s,",")
	for x,y:= range ss {
		fmt.Println(x,y)
	}
	fmt.Println(strings.Join(ss,"=="))
	//字符转换
	fmt.Println(strconv.Itoa(10))//int转string
	fmt.Println(strconv.Atoi("10"))//string 转 int返回两个参数结果和是否成功value,err
}
