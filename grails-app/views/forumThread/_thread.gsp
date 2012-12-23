<% def first = true %>
<div class="thread">
    <g:each in="${thread.children.sort{it.dateCreated.getTime()}}" var="post">
    	<g:if test="${first}">
    		<% first = false %>
        	<g:render template="/forumPost/post" model="${[post: post, first: true]}"/>
        </g:if>
        <g:else>
        	<g:render template="/forumPost/post" model="${[post: post, first: false]}"/>
        </g:else>
    </g:each>
</div>