package main

import 	(
	"fmt"
	"sync"
)

func main() {
//无限循环也只会运行一次,当然别无限卡死不负责
	var once sync.Once
	w:= new(sync.WaitGroup)
	for i:=0;i<5;i++ {
		w.Add(1)
		go func(i int) {
			once.Do(func() {
				fmt.Println("only once run")
				})
			fmt.Println(i)
			w.Done()
		}(i)
	}
	w.Wait()
}
