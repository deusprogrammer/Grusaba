package com.ponychan.db.forum

class ForumThread extends ForumObject {
    String topic

    static belongsTo = [parent: ForumBoard]
    static hasMany   = [children: ForumPost]
    
    public findObject(ForumObject object) {
        def found = children.find {it == object}
        
        return found
    }
    
    static constraints = {
    }
}
