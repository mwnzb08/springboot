package main

type Basic struct {
	Name string `json:"name"` //easyjson 注意要带上 `json:xxx`
	Age  int `json:"age"`
}
