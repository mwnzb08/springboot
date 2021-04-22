package main

import "fmt"

func main() {
	//i := new(aa)
	//i.hello()
	//fmt.Println(i.hello())
	//i2 := new(bb)
	//i2.hello()
	var i ii
	i = aa)
	i.hello()
	//i = new(aa)//实例aa
	//i.hello()
	//i = new(bb)//实例bb
	//i.hello()

}

type aa struct {

}

type bb struct {

}

type ii interface {
	hello() //string并不是必须的
}

func (aa *aa) hello() string{
	fmt.Println("hello")
	return "hello"
}

func (bb *bb) hello() {
	fmt.Println("world")

}
