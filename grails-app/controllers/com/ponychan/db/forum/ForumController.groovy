package com.ponychan.db.forum

class ForumController {

    def index() {
        def forum = Forum.findByName("ponychan")
        def boards = []
        
        if(forum) {
            boards = forum.children
        }
        
        [boards: boards]
    }
}
