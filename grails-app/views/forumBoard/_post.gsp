<div class="post-div" style="border:1px solid black; width:800px; minHeight:400px;">
	<g:if test="${post.hasAttachedImage}">
		<div class="post-image" style="display:inline-block;">
			<img src="${createLink(controller: 'file', action: 'getImage', id: post.id)}" width="200px" />
		</div>
	</g:if>
	<div class="post-content" style="display:inline-block;">
	    <span class="post-header" style="display: block; vertical-align: top">[${post.dateCreated}]</span>
	    <span class="post-text" style="display: block; vertical-align: top">${post.text}</span>
    </div>
</div>