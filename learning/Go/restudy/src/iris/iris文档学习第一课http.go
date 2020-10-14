package main

import (
	"github.com/kataras/iris"
	"github.com/kataras/iris/context"
)

func main() {

	app := iris.New()
	// 通用方法
	app.Handle("GET","/hello", func(context context.Context) {
		str:=context.URLParam("name")//Params 用来获取传入的参数。
		app.Logger().Info(str)
		context.WriteString(str)
	})
	//app.Get() //快捷方式
	//app.Post()
	//app.Put()
	//app.Delete()

	app.Run(iris.Addr(":8081"))
}
