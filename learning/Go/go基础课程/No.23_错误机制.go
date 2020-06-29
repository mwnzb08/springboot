package main

import (
	"errors"
	"fmt"
)

//提倡把可能的失败都判定再执行。
func main() {
	if v,err:=intt(-1);err !=nil {//!=nil 表示有错误 ！= 空，即是有错
		fmt.Println("error",err)
	} else {
		fmt.Println(v)
	}
	fmt.Println(intt(1))
}
var err = errors.New("<0")
func intt(op int) (int, error){
	if op < 0  {
		return 404, err//不支持nil了使用返回类型即可
	}
	return op, nil
}
