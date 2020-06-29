package main

import (
	"github.com/kataras/iris"
	"github.com/kataras/iris/context"
)

func main() {
	app:=iris.New()//创建iris对象

	app.Get("/", func(context context.Context) {//get 请求
		app.Logger().Info("start to do gen")
		name:=context.URLParam("name")
		context.HTML(" <h1>hello,"+name+"</h1>")
		app.Logger().Info("end to do gen")
	})

	app.Get("/hello", func(context context.Context) {
		context.WriteString("hello>>=" + context.Path())
	})

	app.Post("/post", func(context context.Context) {
		name:=context.PostValue("name")
		context.HTML(" <h1>hello,"+name+"</h1>")
	})

	app.Run(iris.Addr(":8080"))//最后一个执行,监听的端口
}
