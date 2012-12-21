package com.ponychan.db.users

import com.ponychan.db.forum.ForumObject

/**A role given to a user allowing them to act on a ForumObject they don't own
 * and all it's child elements
 * 
 * @author mich4570
 *
 */

class UserRole {
    Role role                       //The users abilities on responsibility
    ForumObject responsibility      //Forum object a user doesn't own

    static constraints = {
    }
}
