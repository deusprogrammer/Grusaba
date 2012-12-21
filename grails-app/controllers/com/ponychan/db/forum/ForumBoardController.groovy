package com.ponychan.db.forum

//Only the owner of the forum should be able to access this controller
class ForumBoardController {

    def show(Long id) { 
        def board = ForumBoard.get(id)
        
        if (!board) {
            println "Unable to find the requested board"
            flash.message = "Unable to find the requested board"
            redirect(controller: "forum", action: "index")
        }
        
        [board: board]
    }
    
    def board(String abbrev) {
        def board = ForumBoard.findByAbbreviation("/" + abbrev + "/")
        
        println "ABBREV: ${abbrev}"
                
        if (!board) {
            println "Unable to find the requested board"
            flash.message = "Unable to find the requested board"
            redirect(controller: "forum", action: "index")
        }
        
        [board: board]
    }
    
    def create() {
        if (!params.forum) {
            flash.message = "Invalid parameter passed."
            redirect(action: index)
            return
        }
        
        def forum = Forum.findByName(params.forum)
        
        if (!forum) {
            flash.message = "No forum named ${params.forum}."
            redirect(action: index)
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
        
        redirect(action: "show")
        return
    }
    
    def edit(Long id) {
        def board = ForumBoard.get(id)
        
        if (!board) {
            flash.message = "No such board exists."
            redirect(controller: "forum", action: "index")
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
