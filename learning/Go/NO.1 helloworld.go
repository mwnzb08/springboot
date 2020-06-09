package main

import (
	"fmt"
)
//模拟一个简单的登录过程
func main() {
	a:=1
	var (
		b int
		c string
	)
	fmt.Println("helloWorld",a)
	b = login()
	if b==0 {
		login()
	}
	for {
		c = stay()
		d:=logout(c)
		if d==0 {
			fmt.Println("see you")
			return
		}
		fmt.Println(c)
	}
}

func login() int {
	pwd:="123456"
	var n,p string
	fmt.Println("PLS add you name")
	fmt.Print("name: ")
	fmt.Scanln(&n)
	fmt.Print("password: ")
	fmt.Scanln(&p)
	if p==pwd {
		fmt.Println("Welcome to Go World ",n)
		return 1
	} else {
		fmt.Println("pwd error try again")
		return 0
	}
}

func stay () string {
	var a string
	fmt.Scanln(&a)
	return a
}

func logout(x string) int {
	y:=1
	if x=="exit" || x=="quit" {
		y = 0
	}
	return y
}