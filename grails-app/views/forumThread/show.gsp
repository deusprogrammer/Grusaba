<html>
<body>
	<h3>${thread.topic} [${thread.dateCreated}]</h3><br/>
    <g:render template="newPostForm" />
	<g:render template="thread" model="${[thread: thread]}" />
    <g:link controller="forumBoard" action="show" id="${thread.parent.id}">Return to ${thread.parent.abbreviation}</g:link>
</body>
</html>