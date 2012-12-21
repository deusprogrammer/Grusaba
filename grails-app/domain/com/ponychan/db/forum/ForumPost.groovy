package com.ponychan.db.forum

class ForumPost extends ForumObject {
    String text
    String attachedImage
    boolean hasAttachedImage = false

    static belongsTo = [parent: ForumThread]
	
	def getStrippedText() {
		return text.replaceAll(/<!--.*?-->/, '').replaceAll(/<.*?>/, '').replaceAll("\n", "<br/>").replaceAll(/\[youtube\](.*)\[\/youtube]/, "<iframe width='560' height='315' src='http://www.youtube.com/embed/\$1' frameborder='0' allowfullscreen></iframe>")
	}
    
    static constraints = {
        attachedImage nullable: true
    }
}