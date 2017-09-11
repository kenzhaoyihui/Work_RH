package controllers

import (
	"github.com/astaxie/beego"
)

type MainController struct {
	beego.Controller
}

func (c *MainController) Get() {
	c.Data["Website"] = "yzhao.me"
	c.Data["Email"] = "zhaoyihui.ken@gmail.com"
	c.TplName = "index.tpl"

	c.Data["TrueCond"] = true
	c.Data["FalseCond"] = false

	type u struct {
		Name string
		Age  int
		Sex  string
	}

	user := &u{
		Name: "hyzsherry",
		Age:  23,
		Sex:  "man",
	}

	c.Data["User"] = user

	nums := []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
	c.Data["Nums"] = nums

	c.Data["Tp"] = "hey guys"
	c.Data["Html"] = "<div> Hello Beego</div>"
	c.Data["Pipe"] = "<div> Hello Beego2</div>"

}
