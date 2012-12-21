package com.ponychan.forum

import java.security.MessageDigest
import org.springframework.web.multipart.commons.CommonsMultipartFile

import org.imgscalr.Scalr
import javax.imageio.ImageIO

class FileService {
	def store(final file) {
		def path = null
		if (!file.empty) {
			def filename = file.getOriginalFilename()
			def md5 = generateMD5(file)
			def extension = getExtension(file)
			
			path = "C:/tmp/" + md5 + extension
			
			file.transferTo(new File(path))
		}
		
		return path
	}
	
	def writeThumbnail(String filename, OutputStream out) {
		def file  = new File(filename)
		
		if (!file || file.size() == 0) {
			return false
		}		
		
		String ext = getExtension(file)
		def image = ImageIO.read(file)
		def thumbnail = Scalr.resize(image, 200)
		
		switch (ext.toLowerCase()) {
			case ".gif":
				ImageIO.write(thumbnail, "GIF", out)
				break
			case ".png":
				ImageIO.write(thumbnail, "PNG", out)
				break
			case ".jpg":
			case ".jpeg":
			default:
				ImageIO.write(thumbnail, "JPEG", out)
				break
		}
		
		return true
	}
	
	def writeImage(final String filename, OutputStream out) {
		def file = new File(filename)
		
		if (!file || file.size() == 0) {
			return false
		}
		
		def image = ImageIO.read(file)
		String ext = getExtension(file)
		
		switch (ext.toLowerCase()) {
			case ".gif":
				ImageIO.write(image, "GIF", out)
				break
			case ".png":
				ImageIO.write(image, "PNG", out)
				break
			case ".jpg":
			case ".jpeg":
			default:
				ImageIO.write(image, "JPEG", out)
				break
		}
		
		return true
	}
	
	def getExtension(final CommonsMultipartFile file) {
		def filename = file.getOriginalFilename()
		
		if (filename.lastIndexOf('.')) {
			return filename[filename.lastIndexOf('.')..-1]
		}
		else {
			return ""
		}
	}
	
	def getExtension(final File file) {
		def filename = file.name
		
		if (filename.lastIndexOf('.')) {
			return filename[filename.lastIndexOf('.')..-1]
		}
		else {
			return ""
		}
	}
	
	def generateMD5(final file) {
		//I realize this isn't a hash
		return new Date().getTime()
	}
}