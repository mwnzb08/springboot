package main

import "fmt"

func main() {
	//依旧不需要括起来
	if a:= 1 > 0;a { //a>0 true a=true
		fmt.Println("a=1")
	}
	//for a:= 0; a <10 ; a++ {
	//	switch a { //可以匹配多个值
	//	case 1,2,3:
	//		fmt.Print("1")
	//	case 4,5,6:
	//		fmt.Print("2")
	//	}
	//}
	for a:= 0; a <10 ; a++ {
		switch { //支持判断 ,无参
		case a> 5:
			fmt.Print("1")
		case a<1:
			fmt.Print("2")
		}
	}

}
