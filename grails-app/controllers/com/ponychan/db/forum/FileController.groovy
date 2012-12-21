package com.ponychan.db.forum

class FileController {

    def index() { }
	
	def getThumbnail(Long id) {
		
	}
	
	def getImage(Long id) {
		def post = ForumPost.get(id)
		
		if (!post || !post.attachedImage) {
			response.status = 404
			return
		}
		
		def file = new File(post.attachedImage)
		
		if (!file || file.size() == 0) {
			response.status = 404
			return
		}
		
		response.outputStream << new File(post.attachedImage).readBytes()
		return
	}
}
