package com.ponychan.db.users

import com.ponychan.db.forum.ForumObject

class RegisteredUser extends User {
    String username
    String password
    
    static hasMany = [ipAddresses: IPAddress, roles: UserRole]
    
    public PermissionsMask fetchObjectPermissions(ForumObject object) {
        def role = roles.find {it.responsibility == object}
    }

    static constraints = {
    }
}
