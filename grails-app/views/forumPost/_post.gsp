<div class="post">
	<div class="post-header">${post.owner.username ?: "anonymous"} | IP: ${post.owner.ipAddress} | [${post.dateCreated}]</div>
	<div class="post-content" style="display:inline-block;">
		<g:if test="${post.hasAttachedImage}">
			<div class="post-image">
				<a class="image-link" href="${createLink(controller: 'file', action: 'getImage', id: post.id)}"><img class="post-image" style="vertical-align: top" src="${createLink(controller: 'file', action: 'getThumbnail', id: post.id)}" /></a>
			</div>
		</g:if>	    
	    <div class="post-text">${post.strippedText}</div>
    </div>
</div>