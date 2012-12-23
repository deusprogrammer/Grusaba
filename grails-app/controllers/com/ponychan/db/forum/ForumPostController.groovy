package com.ponychan.db.forum

import com.ponychan.db.users.*

class ForumPostController {
	
	def fileService
	def userService

    def index() { }
    
    def save() {
		def user = userService.getCurrentUser()
		
		if (!user) {
			println "Unknown error."
			flash.message = "Unknown error."
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
		def f = request.getFile('uploadFile')
		def path = fileService.store(f)
		
        def post = new ForumPost(params)
        post.name = "POST"
		post.owner = user
		
		if (path) {
			post.attachedImage = path
	        post.hasAttachedImage = true
		}
		
		user.addToForumObjects(post)
		user.lastPost = user.lastSeen = new Date()
		
        if (!post.save()) {
            flash.message = post.errors
            redirect(controller: "forumThread", action: "show", id: params.parent.id)
            return
        }
		
		if (!user.save()) {
			flash.message = user.errors
			redirect(controller: "forumThread", action: "show", id: params.parent.id)
			return
		}
        
        redirect(controller: "forumThread", action: "show", id: params.parent.id)
    }
}
