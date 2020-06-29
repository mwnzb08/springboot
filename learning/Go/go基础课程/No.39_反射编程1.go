package main

import (
	"fmt"
	"reflect"
)

func main() {
	a:=1
	b:="1"
	c:=true
	//reflect.ValueOf(a)返回值,可以直接.Type获取值的类型
	//reflect.TypeOf(a)返回类型
	fmt.Println(reflect.ValueOf(a),reflect.TypeOf(a))
	fmt.Println(reflect.ValueOf(b),reflect.TypeOf(b))
	fmt.Println(reflect.ValueOf(c),reflect.TypeOf(c))
	fmt.Println(reflect.ValueOf(c).Type())
	d:=reflect.TypeOf(a)
	switch d.Kind() {//使用Kind（）枚举是什么类型
	case reflect.Int:
		fmt.Println("a is int")
	}

}
