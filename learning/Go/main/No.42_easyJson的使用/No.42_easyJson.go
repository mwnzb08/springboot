package main

import "fmt"

//easyjson的使用
//第一步下载地址GitHub.com/mailru/easyjson/...
//第二步编写struct 文件
//第三步执行生成json的文件
//GOPATH/bin/easyjson -all D:\Git\learning\Go\restudy\src\main\struct.go
func main() {
	var jsonStr = `{"name":"mo","age":30}`
	a:= new(Basic)
	if err:= a.UnmarshalJSON([]byte(jsonStr)); err !=nil {
		fmt.Println("errorsss")
	}
	fmt.Println(*a)
	if k,err:=a.MarshalJSON();err != nil {
		fmt.Println("error")
	} else {
		fmt.Println(string(k))
	}
}
