package com.ponychan.db.forum

import java.awt.image.BufferedImage
import org.grails.plugins.imagetools.*
import javax.imageio.ImageIO
import org.imgscalr.Scalr

class FileController {

    def index() { }
	
	def fileService
	
	def getThumbnail(Long id) {
		def post = ForumPost.get(id)
		
		if (!post || !post.attachedImage) {
			response.status = 404
			return
		}
		
		if (!fileService.writeThumbnail(post.attachedImage, response.outputStream)) {
			response.status = 404
			return	
		}
		
		return
	}
	
	def getImage(Long id) {
		def post = ForumPost.get(id)
		
		if (!post || !post.attachedImage) {
			response.status = 404
			return
		}
		
		if (!fileService.writeImage(post.attachedImage, response.outputStream)) {
			response.status = 404
			return
		}
		
		return
	}
}
