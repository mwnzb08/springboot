package main

import (
	"fmt"
	"os"
)

func main() {
	fmt.Println("hello world ")
	//fmt.Println("hello world " + os.Args[2])//传参 go run xxx.go 123 456 ==> hello world 456
	os.Exit(404) //用于返回值
}
