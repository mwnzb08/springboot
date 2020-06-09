package main

import "fmt"

func main() {
	//数组的声明方式，在类型前加[]
	var a [10]int//or 必须指定长度 int 默认是0，不可以使用...
	a[0] = 5
	b:=[...]int{1,2,3}//可以使用...代替个数，这里是3
	b[1] = 3
	fmt.Println(a,b)
	//数组的遍历（非常规）
	for _,e := range b {//range 遍历
		fmt.Print(e)
	}
	//数组的截取b[x:y] x=起始位置（包含）， y=结束位置（不包含）
	fmt.Print(b[1:2])
	fmt.Print(b[1:])//不写代表全部[:2]index 0-2,[1:] index >=1 [:] 所有
}


