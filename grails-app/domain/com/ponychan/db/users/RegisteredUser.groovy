package com.ponychan.db.users

import com.ponychan.db.forum.ForumObject

class RegisteredUser extends User {
    String username
    String password
	String[] ipAddresses
    
    static hasMany = [roles: UserRole]
    
    public PermissionsMask fetchObjectPermissions(ForumObject object) {
        def role = roles.find {it.responsibility == object}
    }
	
	public getIpAddress() {
		return ipAddresses[0]
	}

    static constraints = {
    }
}
