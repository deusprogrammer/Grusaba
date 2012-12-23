package com.ponychan.forum

import com.ponychan.db.users.*
import javax.servlet.http.HttpSession
import org.springframework.web.context.request.RequestContextHolder

class UserService {
	def updateLastSeen() {
		def user = currentUser
		
		user.lastSeen = new Date()
		user.save()
	}
	
    def updateLastPost(String ipAddress) {
		def user = currentUser
		
		user.lastPost = new Date()
		user.save()
    }
	
	def setCurrentUser(def user) {
		session.user = user.id
		session.userType = user.getClass().getSimpleName()
	}
		
	def getCurrentUser() {
		if (!session.user || !session.userType) {
			return null
		}
		
		def id   = session.user
		def type = session.userType
		def user
		
		switch (type) {
		case "RegisteredUser":
			user = RegisteredUser.get(id)
			break
		case "AnonymousUser":
			user = AnonymousUser.get(id)
		default:
			break
		}
		
		return user
	}
	
	protected getSession() {
		return RequestContextHolder.currentRequestAttributes().getSession()
	}
}
