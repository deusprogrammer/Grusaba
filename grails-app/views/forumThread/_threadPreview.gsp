<% def first = true %>
<div class="thread">
	<%
		def list = thread.children.sort{it.dateCreated.getTime()}
		def preview
	
		if (list.size() >= 4) {
		    preview = list[0..0] + list[-3..-1]
		} else {
		    preview = list
		}
		
		def moreThanThree = list.size() > 3
	%>
    <g:each in="${preview}" var="post">
    	<g:if test="${first}">
    		<% first = false %>
        	<g:render template="/forumPost/post" model="${[post: post, first: true, moreThanThree: moreThanThree, preview: true]}"/>
        </g:if>
        <g:else>
        	<g:render template="/forumPost/post" model="${[post: post, first: false, moreThanThree: moreThanThree, preview: true]}"/>
        </g:else>
    </g:each>
</div>