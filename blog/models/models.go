package models

import (
	"time"
)

type Categroy struct{
	Id int64
	Title string
	Created time.Time 
	views int64
}

