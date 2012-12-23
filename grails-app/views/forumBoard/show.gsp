<html>
	<head>
		<meta name="layout" content="board">
	</head>
	<body>
	    <div class="title"><h1 class="board">${board.abbreviation}- ${board.name}</h1></div>
	    <hr />
	    <g:render template="/forumThread/newThreadForm" />
	    <hr />
	    <g:each in="${board.children.sort{it.dateCreated.getTime()}}" var="thread">
	        <g:render template="/forumThread/thread" model="${[thread: thread]}" />
	    </g:each>
	    <a href="${createLink(controller: 'forum', action: 'index')}">Return to index</a>
	</body>
</html>