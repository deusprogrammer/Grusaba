package com.ponychan.db.forum

//Only the owner of the forum should be able to access this controller
class ForumBoardController {
	def userService
	
    def show(Long id) {
        def board = ForumBoard.get(id)
        
        if (!board) {
            println "Unable to find the requested board"
			flash.message = "Unable to find the requested board"
            redirect(controller: "forum", action: "index")
			return
        }
        
        [board: board]
    }
    
    def board(String id) {
		def board = ForumBoard.findByAbbreviation("/" + id + "/")
        
        println "ABBREV: ${id}"
                
        if (!board) {
            println "Unable to find the requested board"
			flash.message = "Unable to find the requested board"
            redirect(controller: "forum", action: "index")
			return
        }
        
        render(view: "show", model: [board: board])
    }
    
    def create() {
        if (!params.forum) {
            flash.message = "Invalid parameter passed."
            redirect(action: "index")
            return
        }
        
        def forum = Forum.findByName(params.forum)
        
        if (!forum) {
            flash.message = "No forum named ${params.forum}."
            redirect(action: "index")
            return
        }
        
        [forum: forum]
    }
    
    def save() {
        def board = new ForumBoard(params)
        
        if (!board.save(flush:true)) {
            flash.message = board.errors
            redirect(controller: "forum", action: "createBoard")
            return
        }
        
        redirect(controller: "forum", action: "index")
        return
    }
    
    def edit(Long id) {
        def board = ForumBoard.get(id)
        
        if (!board) {
            response.status = 404
			return
        }
        
        [board: board]
    }
    
    def update() {
        def board = new ForumBoard(params)
        
        if (!board.save(flush:true)) {
            flash.message = board.errors
            redirect(controller: "forum", action: "createBoard")
            return
        }
        
        redirect(action: "show")
        return
    }
}
