package com.ponychan.db.forum

import com.ponychan.db.users.*

class ForumPostController {
	
	def fileService
	def userService

    def index() { }
    
    def save() {
		def user = userService.getCurrentUser()
		session["lastNameUsed"] = [name: params.name, email: params.email]
		
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
		def map = fileService.store(f)
		def path = map.path
		def thumb = map.thumb
		
        def post = new ForumPost(params)
		post.owner = user
		post.email = params.email
		
		//Bump
		def parent = ForumThread.get(params.parent.id)
		if (parent) {
			parent.lastUpdated = new Date()
			parent.save()
		}
		
		if (path) {
			post.attachedImage = path
			post.attachedThumbnail = thumb
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
        
        redirect(controller: "forumThread", action: "show", id: params.parent.id, params: [board: post.parent.parent.abbreviation.replaceAll("/", "")])
    }
}
