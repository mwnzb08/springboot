package main

import (
	"fmt"
)

func main() {
	defer func() {
		if err:=recover();err !=nil {
		// recover 可以恢复程序，但是可能依旧不能用，不明显的报错，
		//再次执可能还是一样的结果。
		//但是便于搜索
			fmt.Println("end",err)
		}
	}()
	fmt.Println("start")
	//os.Exit(-1)
	panic("error")
	fmt.Println("real end")
}
