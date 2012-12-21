package com.ponychan.db.users

import com.ponychan.db.users.PermissionsMask

class Role {
    String roleName
    String mask
        
    public PermissionsMask getPermissionsMask() {
        return new PermissionsMask(mask)
    }
    
    public String toString() {
        return roleName + "(${mask})"
    }
    
    static constraints = {
    }
}
