package main

import (
	"fmt"
	"net/http"
	"time"
)

func main() {

	http.HandleFunc("/", func(writer http.ResponseWriter, request *http.Request) {
		fmt.Fprintf(writer,"hello")
	})
	http.HandleFunc("/time", func(writer http.ResponseWriter, request *http.Request) {
		t:=time.Now()
		writer.Write([]byte(t.String()))
	})
	http.ListenAndServe("localhost:8080",nil)
}
