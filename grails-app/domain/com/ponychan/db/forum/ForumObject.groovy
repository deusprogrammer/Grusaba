package com.ponychan.db.forum

import com.ponychan.db.users.User;

class ForumObject {
    String name
    
    Date dateCreated
    Date lastUpdated
    User owner

    static constraints = {
        owner nullable: true
    }
}
