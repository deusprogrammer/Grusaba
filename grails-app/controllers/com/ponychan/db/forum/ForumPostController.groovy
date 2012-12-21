package com.ponychan.db.forum

class ForumPostController {
	
	def fileService

    def index() { }
    
    def save() {
		def f = request.getFile('uploadFile')
		def path = fileService.store(f)
		
        def post = new ForumPost(params)
        post.name = "POST"
		if (path) {
			post.attachedImage = path
	        post.hasAttachedImage = true
		}
		
        if (!post.save()) {
            flash.message = post.errors
            redirect(controller: "forumThread", action: "show", id: params.parent.id)
            return
        }
        
        redirect(controller: "forumThread", action: "show", id: params.parent.id)
    }
}
