<g:if test="${first}">
	<div class="first-post">
	<div class="post-header"><span class="poster"><a alt="${post.owner.ipAddress}" href="#">${post.owner.username ?: "anonymous"}</a></span> ${post.dateCreated} No. ${post.id} [<a href="${createLink(controller:'forumThread', action: 'show', id: post.parent.id)}">Reply</a>]</div>
</g:if>
<g:else>
	<div class="post">
	<div class="post-header"><span class="poster"><a alt="${post.owner.ipAddress}" href="#">${post.owner.username ?: "anonymous"}</a></span> ${post.dateCreated} No. ${post.id}</div>
</g:else>
	<div class="post-content" style="display:inline-block;">
		<g:if test="${post.hasAttachedImage}">
			<div class="post-image">
				<a class="image-link" href="${createLink(controller: 'file', action: 'getImage', id: post.id)}"><img class="post-image" style="vertical-align: top" src="${createLink(controller: 'file', action: 'getThumbnail', id: post.id)}" /></a>
			</div>
		</g:if>	    
	    <div class="post-text">${post.strippedText}</div>
    </div>
</div>