package com.ponychan.db.forum

import com.sun.xml.internal.ws.org.objectweb.asm.Item;

class ForumBoard extends ForumObject {
    String abbreviation 
   
    static belongsTo = [parent: Forum]
    static hasMany   = [children: ForumThread]
    
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
    
    public String toString() {
        return "${abbreviation}- ${name} (${id})"
    }

    static constraints = {
    }
}
