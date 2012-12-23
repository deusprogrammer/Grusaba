package com.ponychan.db.users

import com.ponychan.db.forum.ForumObject
import com.ponychan.db.forum.ForumPost
import com.ponychan.db.forum.ForumThread

class User {
    Date dateCreated
    Date lastSeen = new Date()
	Date lastPost
    
    static hasMany = [forumObjects: ForumObject, threads: ForumThread, posts: ForumPost, contributedTo: ForumThread]

    static constraints = {
		lastSeen nullable: true
		lastPost nullable: true
    }
}
