<html>
	<head>
		<meta name="layout" content="board">
		<title>${thread.topic}</title>
	</head>
	<body>
		<div class="title"><h1 class="board">${thread.parent.abbreviation}- ${thread.parent.name}</h1></div>
		<hr />
		<div class="mode">Posting Mode: Reply</div>
	    <g:render template="/forumPost/newPostForm" model="${[controller: 'forumPost']}" />
	    <hr />
		<g:render template="thread" model="${[thread: thread]}" />
	    <g:link controller="forumBoard" action="show" id="${thread.parent.id}">Return to ${thread.parent.abbreviation}</g:link>
	</body>
</html>