package main

import (
	"fmt"
	"os"
)

func main() {
	fmt.Println("hello world ")
	//fmt.Println("hello world " + os.Args[2])//传参 go run xxx.go 123 456 ==> hell
	os.Exit(404) //用于返回值
}
