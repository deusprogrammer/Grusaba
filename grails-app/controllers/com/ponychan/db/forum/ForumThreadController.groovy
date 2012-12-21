package com.ponychan.db.forum

class ForumThreadController {

    def index() { }
    
    def show(Long id) {
        def thread = ForumThread.get(id)
        
        if (!thread) {
            println "No thread with id ${id}"
            flash.message = "No thread with id ${id}"
            redirect(controller: "forum", action:"index")
            return
        }
        
        [thread: thread]
    }
    
    def save() {
        def thread = new ForumThread(params)
        def firstPost = new ForumPost()
        firstPost.text = params.post.text
        firstPost.name = "POST"
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