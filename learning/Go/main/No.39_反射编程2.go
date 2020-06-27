package main

import (
	"fmt"
	"reflect"
)

func main() {

	e:= &elem{"mo",5,true}
	//使用fieldByName获取结构内的名称的值。
	fmt.Println(reflect.ValueOf(*e).FieldByName("name"))
	if x,ok:=reflect.TypeOf(*e).FieldByName("name");ok {
		fmt.Println(x)
		fmt.Println(x.Tag.Get("json"))//获取标签
	} else {
		fmt.Println("error")
	}
	//记住结构 MethodByName获取方法然后赋值
	reflect.ValueOf(e).MethodByName("Gets").
		Call([]reflect.Value{reflect.ValueOf(100)})
	fmt.Println(e)
}

type elem struct {
	name string `json:"name"`//key ：value
	age int
	sex bool
}

func (e *elem) Gets(ages int) {//注意首字母要大写才能访问到
	e.age = ages
}
