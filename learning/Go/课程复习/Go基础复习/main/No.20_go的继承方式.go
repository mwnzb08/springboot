package main

import "fmt"
//记住点点点a.b就是b的方法了
func main() {
	c:= new(cat)
	c.speakTo("miao")
	d:=new(dog)
	d.speakTo("wang")//dog.speakTo ->dog.cat.speak()->.....

}

type cat struct {
}

type dog struct {
	cat
}

func (c *cat) speak() {
	fmt.Println("喵")
}

func (c *cat) speakTo(op string) {
	c.speak()
	fmt.Println(op + "喵")
}

func (d *dog) speak() {
	fmt.Println("汪")
}

func (d *dog) speakTo(op string) {
	d.cat.speak()
	fmt.Println(op + "汪")
}
