package main

import "fmt"

func main() {
	interfaceType(1)
	interfaceType("1")
	interfaceType(true)
}

func interfaceType(op interface{}) { //interface{}表示空接口，可以传入任何类型
	switch a:=op.(type) {
	case int:
		fmt.Println("int",a)
	case string:
		fmt.Println("string")
	default:
		fmt.Println("no")
	}

}
