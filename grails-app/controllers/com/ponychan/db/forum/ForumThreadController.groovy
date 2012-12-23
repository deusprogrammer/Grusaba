package com.ponychan.db.forum

import com.ponychan.db.users.*

class ForumThreadController {
	
	def fileService
	def userService

    def index() { }
    
    def show(Long id) {
        def thread = ForumThread.get(id)
        
        if (!thread) {
            println "No thread with id ${id}"
            response.status = 404
			return
        }
        
        [thread: thread]
    }
    
    def save() {
		def user = userService.getCurrentUser()
		
		if (!user) {
			println "Unknown error."
			flash.message = "Unknown error."
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
		//Get file
		def f = request.getFile('uploadFile')
		def path = fileService.store(f)
		
		if (!path) {
			println "You must attach a picture to start a thread!"
			flash.message = "You must attach a picture to start a thread!"
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
        def thread = new ForumThread(params)
        def firstPost = new ForumPost()
		
        firstPost.text = params.post.text
        firstPost.name = "POST"
		firstPost.owner = user
		firstPost.attachedImage = path
		firstPost.hasAttachedImage = true
		
        thread.name = "THREAD"
		thread.owner = user
        thread.addToChildren(firstPost)
		
		user.addToForumObjects(thread)
		user.addToForumObjects(firstPost)
		user.lastPost = user.lastSeen = new Date()
        
        if (!thread.save()) {
            println "ERRORS:"
            thread.errors.each {println it}
            flash.message = thread.errors
            redirect(controller: "forumBoard", action: "show", id: params.parent.id)
            return
        }
		
		if (!user.save()) {
			println "ERRORS:"
			user.errors.each {println it}
			flash.message = user.errors
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
        
        redirect(action: "show", id: thread.id)
    }
}