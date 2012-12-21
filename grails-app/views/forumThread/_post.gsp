<div class="post-div" style="border:1px solid black; width:800px; minHeight:400px;">
	<g:if test="${post.hasAttachedImage}">
		<div class="post-image-div" style="display:inline-block;">
			<img class="post-image" style="vertical-align: top" src="${createLink(controller: 'file', action: 'getImage', id: post.id)}" width="200px" />
		</div>
	</g:if>
	<div class="post-content" style="display:inline-block;">
	    <div class="post-header" style="vertical-align: top">[${post.dateCreated}]</div>
	    <div class="post-text" style="vertical-align: top">${post.text}</div>
    </div>
</div>