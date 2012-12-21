package com.ponychan.db.forum

class ForumPost extends ForumObject {
    String text
    String attachedImage
    boolean hasAttachedImage = false

    static belongsTo = [parent: ForumThread]
    
    static constraints = {
        attachedImage nullable: true
    }
}