package test

import (
	"bytes"
	"strconv"
	"strings"
	"testing"
)

//func TestFunc(t *testing.T) {
//	t.Log("start")
//	//error 是可以继续执行接下来的程序的
//	t.Error("o")
//	t.Log("start")
//
//}
//
//func TestFunc2(t *testing.T) {
//	t.Log("start")
//	//fatal是不可以继续运行接下来的程序的
//	t.Fatal("o")
//	t.Log("start")
//
//}

func TestCoverRate(t *testing.T) {
	cheng(5)
}
//Benchmark测试性能以benchmark 开头结果strings.Builder最快 ++ 的超级慢
func BenchmarkFunc(b *testing.B) {
	ele:=[]int{1,2,3,4,5}
	b.ResetTimer()
	for i:=0;i<b.N ;i++  {
		var buf  bytes.Buffer
		for _,elem:=range ele  {
			buf.WriteString(strconv.Itoa(elem))
		}
	}
	b.StopTimer()
}

func BenchmarkFunc2(b *testing.B) {
	ele:=[]int{1,2,3,4,5}
	b.ResetTimer()
	for i:=0;i<b.N ;i++  {
		var buf  strings.Builder
		for _,elem:=range ele  {
			buf.WriteString(strconv.Itoa(elem))
		}
	}
	b.StopTimer()
}

func BenchmarkFunc3(b *testing.B) {
	ele:=[]int{1,2,3,4,5}
	eles:=""
	b.ResetTimer()
	for i:=0;i<b.N ;i++  {
		for _,elem:=range ele  {
			eles += strconv.Itoa(elem)
		}
	}
	b.StopTimer()
}



//使用go test -v -cover 获得测试的覆盖率
//github.com/stretchr/testify/assert测试github项目的使用
//
//func TestGithub(t *testing.T) {
//	c := cheng(5)
//	assert.Equal(t,20,c)//t,期望的值,实际得到的值
//}

//bdd的使用略............
