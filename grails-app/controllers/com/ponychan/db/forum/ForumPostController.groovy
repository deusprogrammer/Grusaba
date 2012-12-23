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
			redirect(controller: "forumThread", action: "show", id: params.parent.id)
			return
		}
		
		if (!userService.canPost()) {
			println "You must wait before you can post again."
			flash.message = "You must wait before you can post again."
			redirect(controller: "forumThread", action: "show", id: params.parent.id)
			return
		}
		
		def f = request.getFile('uploadFile')
		def path = fileService.store(f)
		
        def post = new ForumPost(params)
		post.owner = user
		post.email = params.email
		
		if (path) {
			post.attachedImage = path
	        post.hasAttachedImage = true
		}
		
		user.addToForumObjects(post)
		user.lastPost = user.lastSeen = new Date()
		
        if (!post.save(flush: true)) {
            flash.message = post.errors
            redirect(controller: "forumThread", action: "show", id: params.parent.id)
            return
        }
		
		if (!user.save(flush: true)) {
			flash.message = user.errors
			redirect(controller: "forumThread", action: "show", id: params.parent.id)
			return
		}
		
		println "POSTER NAME: ${post.name}"
		println "EMAIL:       ${post.email}"
        
        redirect(controller: "forumThread", action: "show", id: params.parent.id)
    }
}
