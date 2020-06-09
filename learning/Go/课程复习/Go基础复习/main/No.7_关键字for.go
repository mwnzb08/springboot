package main

import "fmt"

func main() {
	//不需要括起来；；；for a:=0 ; a<5 ;a++ {}
	a:=5
	for a >= 0 {
		fmt.Println(">>",a)
		a--
	}
}
