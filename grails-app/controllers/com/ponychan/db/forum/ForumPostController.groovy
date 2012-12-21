package com.ponychan.db.forum

class ForumPostController {

    def index() { }
    
    def save() {
        def post = new ForumPost(params)
        post.name = "POST"
        
        if (!post.save()) {
            flash.message = post.errors
            redirect(controller: "forumThread", action: "show", id: params.parent.id)
            return
        }
        
        redirect(controller: "forumThread", action: "show", id: params.parent.id)
    }
}
