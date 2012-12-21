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
		
		def file  = new File(post.attachedImage)
		String ext   = fileService.getExtension(file)
		def image = ImageIO.read(file)
		def thumbnail = Scalr.resize(image, 200)
		switch (ext.toLowerCase()) {
			case ".gif":
				ImageIO.write(thumbnail, "GIF", response.outputStream)
				break
			case ".png":
				ImageIO.write(thumbnail, "PNG", response.outputStream)
				break
			case ".jpg":
			case ".jpeg":
			default:
				ImageIO.write(thumbnail, "JPEG", response.outputStream)
				break
		}
		
		return
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
