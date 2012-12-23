package com.ponychan.db.users

class SecurityFilters {
	
	def userService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
				def ipAddress = request.getRemoteAddr()
				def currentUser = userService.getCurrentUser()
				if (!currentUser) {
					def user = AnonymousUser.findByIpAddress(ipAddress)
					
					if (!user) {
						println "NEW IP HAS CONNECTED!"
						user = new AnonymousUser(ipAddress: ipAddress)
						user.lastPost = new Date()
						user.save(flush: true)
					}
					else {
						println "THIS IP HAS CONNECTED BEFORE!"
					}
					
					userService.setCurrentUser(user)
					currentUser = user
					
					println "USER IS LOGGED IN ANONYMOUSLY AS IP ${user.ipAddress}"
				}
				else {
				}
				
				if (currentUser.banned) {
					redirect(controller: "error", action: "banned")
					return
				}
            }
            after = { Map model ->

            }
            afterView = { Exception e ->
            }
        }
		
		seen(action: 'show|board|create') {
			before = {
				def currentUser = userService.getCurrentUser()
				userService.updateLastSeen()
				println "UPDATING LAST SEEN"
				println "LAST SEEN: ${currentUser.lastSeen}"
				println "LAST POST: ${currentUser.lastPost}"
			}
		}
    }
}
