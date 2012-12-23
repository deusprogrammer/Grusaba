class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/"(controller: "forum", action: "index")
		"/board/$id"(controller: "forumBoard", action: "board", id: id)
		"/board/$board/thread/$id"(controller: "forumThread", action: "show", id: id)
		"/admin/board/create"(controller: "forumBoard", action: "create")
		"/admin/$id/edit"(controller: "forumBoard", action: "editBoard", id: id)

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
