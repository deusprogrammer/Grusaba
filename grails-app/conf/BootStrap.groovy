import com.ponychan.db.forum.Forum

class BootStrap {

    def init = { servletContext ->
        if (!Forum.findByName("ponychan")) {
            new Forum(name: "ponychan").save()
        }
    }
    def destroy = {
    }
}
