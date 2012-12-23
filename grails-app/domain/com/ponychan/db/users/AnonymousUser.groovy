package com.ponychan.db.users

class AnonymousUser extends User {
    String ipAddress
	
	def getUsername() {
		return "Anonymous"
	}

    static constraints = {
    }
}
