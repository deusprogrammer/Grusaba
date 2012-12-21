<html>
<body>
	<h3>${thread.topic} [${thread.dateCreated}]</h3><br/>
    <g:render template="newPostForm" />
    <div class="thread-div" style="border:1px solid black; width:800px">
        <g:each in="${thread.children.sort{it.dateCreated.getTime()}}" var="post">
            <g:render template="post" model="${[post: post]}"/>
        </g:each>
    </div>
    <g:link controller="forumBoard" action="show" id="${thread.parent.id}">Return to ${thread.parent.abbreviation}</g:link>
</body>
</html>