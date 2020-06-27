package main

import (
	"fmt"
	"reflect"
)
//开始，反射虽然灵活，但是代价就是性能低下，可读性差。难debug等。
//适关键的特殊类型，使用，类大量重复的操作，又不能使用正常的编程实现。
func main() {
	//使用反射比较map slice//直接比较是只能和nil比较而已的
	//这里使用reflect的deepEqual方法比较可以实现比较两个map slice的是否一样
	map1 :=map[int]int{1:1,2:2}
	map2 :=map[int]int{1:1,2:2}//slice也是一样的比较
	fmt.Println(reflect.DeepEqual(map1,map2))
	in:= new(SameStruct1)
	SaveAllName(in)
	fmt.Println(in.Name)

}
// 创建一个func 给每一个struct 的相同的字段赋值。
type SameStruct1 struct {
	Name string //注意大写的才可以访问,小写Set会报错
}

func SaveAllName (in interface{}) {
	sameName := map[string] string {"Name": "mo"}
	FilterStruct(in,sameName)

}
// elem 获取指针指向的类型
func FilterStruct (in interface{}, mm map[string] string) {
	//忽略一些验证
	for k,v:= range mm {
		reflect.ValueOf(in).Elem().FieldByName(k).Set(reflect.ValueOf(v))
		}
}


