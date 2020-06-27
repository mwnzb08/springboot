package main

import (
	"github.com/kataras/iris"
)

func main() {
	app:=iris.New()

	app.Get("/", func(context iris.Context) {
		context.HTML(" <h1>hello,world</h1>")
	})

	app.Run(iris.Addr(":8080"))//最后一个执行
}
