package com.ponychan.db.forum

class ForumThreadController {
	
	def fileService

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
		//Get file
		def f = request.getFile('uploadFile')
		def path = fileService.store(f)
		
        def thread = new ForumThread(params)
        def firstPost = new ForumPost()
        firstPost.text = params.post.text
        firstPost.name = "POST"
		if (path) {
			firstPost.attachedImage = path
			firstPost.hasAttachedImage = true
		}
        thread.name = "THREAD"
        thread.addToChildren(firstPost)
        
        if (!thread.save()) {
            println "ERRORS:"
            thread.errors.each {println it}
            flash.message = thread.errors
            redirect(controller: "forumBoard", action: "show", id: params.parent.id)
            return
        }
        
        redirect(action: "show", id: thread.id)
    }
}