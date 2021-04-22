package main

import (
	"fmt"
	"log"
	"os"
	"time"
)

func init() {
	log.SetOutput(os.Stdout)
}
func logs(msg int) chan int {
	chans := make(chan int, 5)
	time.Sleep(1500 * time.Millisecond)
	chans <- msg * msg
	return chans
}

func main() {
	times := time.Now()
	var aa int
	go func() {
		aa = <-logs(5)
	}()
	fmt.Println(aa)
	time.Sleep(1503 * time.Millisecond)
	fmt.Println(aa)
	fmt.Print(time.Since(times))
}
