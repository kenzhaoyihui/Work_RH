package routers

import (
	"github.com/kenzhaoyihui/Work_RH/blog/controllers"
	"github.com/astaxie/beego"
)

func init() {
    beego.Router("/", &controllers.MainController{})
}
