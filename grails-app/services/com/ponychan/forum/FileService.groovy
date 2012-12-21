package com.ponychan.forum

import java.security.MessageDigest
import org.springframework.web.multipart.commons.CommonsMultipartFile

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