<html>
	<head>
		<meta name="layout" content="board">
	</head>
	<body>
	    <g:render template="newPostForm" />
		<g:render template="thread" model="${[thread: thread]}" />
	    <g:link controller="forumBoard" action="show" id="${thread.parent.id}">Return to ${thread.parent.abbreviation}</g:link>
	</body>
</html>