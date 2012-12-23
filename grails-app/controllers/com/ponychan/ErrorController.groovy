package com.ponychan

class ErrorController {

    def index() { }
	
	def banned() {
		render "YOU HAVE BEEN BANNED!"
		return
	}
}
