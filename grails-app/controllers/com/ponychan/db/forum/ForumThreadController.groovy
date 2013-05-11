package com.ponychan.db.forum

import com.ponychan.db.users.*

class ForumThreadController {
	
	def fileService
	def userService

    def index() { }
    
    def show(Long id) {
        def thread = ForumThread.get(id)
		
		def lastNameUsed = session["lastNameUsed"]
        
        if (!thread) {
            println "No thread with id ${id}"
            response.status = 404
			return
        }
        
        [thread: thread, last: lastNameUsed]
    }
    
    def save() {
		def user = userService.getCurrentUser()
		
		session["lastNameUsed"] = [name: params.name, email: params.email]
		
		if (!user) {
			println "Unknown error."
			flash.message = "Unknown error."
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
		if (!userService.canPost()) {
			println "You must wait before you can post again."
			flash.message = "You must wait before you can post again."
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
		//Get file
		def f = request.getFile('uploadFile')
		def map = fileService.store(f)
		def path = map.path
		def thumb = map.thumb
		
		if (!path) {
			println "You must attach a picture to start a thread!"
			flash.message = "You must attach a picture to start a thread!"
			redirect(controller: "forumBoard", action: "show", id: params.parent.id)
			return
		}
		
        def thread = new ForumThread(params)
        def firstPost = new ForumPost()
		
		firstPost.name = params.name
		firstPost.topic = params.topic
        firstPost.text = params.post.text
		firstPost.email = params.email
		firstPost.owner = user
		firstPost.attachedImage = path
		firstPost.attachedThumbnail = thumb
		firstPost.hasAttachedImage = true
		
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
		
		println "POSTER NAME: ${firstPost.name}"
		println "EMAIL:       ${firstPost.email}"
        
        redirect(action: "show", id: thread.id, params: [board: thread.parent.abbreviation.replaceAll("/", "")])
    }
}