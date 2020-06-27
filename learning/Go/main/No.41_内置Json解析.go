package main
//使用系统的配置，生产一般不用
import (
	"encoding/json"
	"fmt"
)
func main() {

	var jsonStr = `{
					"basic": {
					"name": "mo",
					"age": 30
					},
					"plus": {
					"sex":"man"
					}
					}`
	a:=new(All)
	err:= json.Unmarshal([]byte(jsonStr), a)//解析
	if err !=nil {
		fmt.Println("error")
	}
	fmt.Println(a)
	if k,err:=json.Marshal(a); err ==nil {//转json
		fmt.Println(string(k))
	} else {
		fmt.Println("errors")
	}

	fmt.Println(a.Plus.Sex)

}

type Basic struct {
	Name string  `json:"name"`
	Age int `json:"age"`
}
type Plus struct {
	Sex string `json:"sex"`
}
type All struct {
	Basic Basic `json:"basic"`
	Plus Plus `json:"plus"`

}
