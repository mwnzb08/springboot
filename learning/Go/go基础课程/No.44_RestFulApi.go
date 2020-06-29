package main

import (
	"fmt"
	"github.com/julienschmidt/httprouter"
	"net/http"
)

func main() {
	router:= httprouter.New()
	router.GET("/",HelloGet)
	router.GET("/getName/:name", NameGet)
	http.ListenAndServe(":8080",router)
}

func HelloGet(w http.ResponseWriter, r *http.Request, _ httprouter.Params) {
	fmt.Fprintf(w,"hello")
}

func NameGet(w http.ResponseWriter, r *http.Request, ps httprouter.Params) {
fmt.Fprintf(w,"my Name is %v ",ps.ByName("name"))
}
