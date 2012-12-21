<html>
	<head>
		<meta name="layout" content="board">
	</head>
	<body>
	    <h2>${board}</h2>
	    <g:render template="newThreadForm" />
	    <g:each in="${board.children.sort{it.dateCreated.getTime()}}" var="thread">
	        <g:render template="/forumThread/thread" model="${[thread: thread]}" />
	    </g:each>
	    <a href="${createLink(controller: 'forum', action: 'index')}">Return to index</a>
	</body>
</html>