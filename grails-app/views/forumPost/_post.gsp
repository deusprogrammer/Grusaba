<g:if test="${first}">
	<div class="first-post">
</g:if>
<g:else>
	<div class="post">
</g:else>
<div class="post-header"><span class="subject">${post.topic}</span> <span class="poster" title="IP: ${post.owner.ipAddress}"><g:if test="${post.email}"><a class="email-link" href="mailto:${post.email}"></g:if>${(post.name != "" && post.name != null) ? post.name : post.owner.username}<g:if test="${post.email}"></a></g:if></span> ${post.lastUpdated} No. <a class="post-number" href="#">${post.id}</a>
<g:if test="${first}">
	[<g:link controller="forumThread" action="show" id="${post.parent.id}" params="${[board: post.parent.parent.abbreviation.replaceAll("/", "")]}">Reply</g:link>]
</g:if>
</div>
<div class="post-content" style="display:inline-block;">
	<g:if test="${post.hasAttachedImage}">
		<div class="post-image">
			<!--<a class="image-link" href="${createLink(controller: 'file', action: 'getImage', id: post.id)}">-->
				<img class="post-image" style="vertical-align: top" src="${createLink(controller: 'file', action: 'getThumbnail', id: post.id)}" image-fullSizeUrl="${createLink(controller: 'file', action: 'getImage', id: post.id)}"/>
			<!--</a>-->
		</div>
	</g:if>	    
    <div class="post-text">${post.strippedText}</div>
   </div>
</div>
<g:if test="${first && moreThanThree && preview}"><div><i>Posts omitted...click reply to expand</i></div></g:if>