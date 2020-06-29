package main

import "fmt"

func main() {

fmt.Println(calNum(1,2,3,4))

}
//使用...type 可以传入可变个数的的参数
func calNum(op ...int) int {
	a:=0
	for _,b:=range op {
		a+=b
	}
	return a
}
