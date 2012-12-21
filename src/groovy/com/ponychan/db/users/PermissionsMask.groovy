package com.ponychan.db.users

class PermissionsMask {
    protected boolean readObject = true
    protected boolean modifyObject = false
    protected boolean deleteObject = false
    
    public PermissionsMask() {}
    
    public PermissionsMask(String permissions) {
        if (permissions.length() != 3) {
            return
        }
        
        permissions.toCharArray().eachWithIndex { value, index ->
            switch (index) {
                case 0:
                    if (value == '-') {
                        readObject = false
                    }
                    else if (value == 'r') {
                        readObject = true
                    }
                    break
                case 1:
                    if (value == '-') {
                        modifyObject = false
                    }
                    else if (value == 'm') {
                        modifyObject = true
                    }
                    break
                case 2:
                    if (value == '-') {
                        deleteObject = false
                    }
                    else if (value == 'd') {
                        deleteObject = true
                    }
                    break
            }
        }
    }
    
    public String toString() {
        return readObject ? "r" : "-" + modifyObject ? "m" : "-" + deleteObject ? "d" : "-"
    }
}
