package com.ponychan.db.forum

class Forum extends ForumObject {
    
    static hasMany = [children: ForumBoard]
    
    public findObject(ForumObject object) {
        def found = children.find {it == object}
        if (!found) {
            for (ForumObject child in children) {
                found = child.findObject(object)
                if (found) {
                    break
                }
            }
            if (!found) {
                return null
            }
        }
        
        return found
    }

    static constraints = {
    }
}
