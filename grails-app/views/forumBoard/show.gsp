<html>
	<head>
		<meta name="layout" content="board">
		<title>${board.abbreviation}- ${board.name}</title>
	</head>
	<body>
	    <div class="title"><h1 class="board">${board.abbreviation}- ${board.name}</h1></div>
	    <hr />
	    <g:render template="/forumPost/newPostForm" model="${[controller: 'forumThread']}" />
	    <hr />
	    <g:each in="${threads}" var="thread">
	        <g:render template="/forumThread/threadPreview" model="${[thread: thread]}" />
	        <hr />
	    </g:each>
	    <g:paginate controller="forumBoard" action="board" id="${board.abbreviation.replaceAll('/', '')}" total="${threadCount}" />
	    <a href="${createLink(controller: 'forum', action: 'index')}">Return to index</a>
	</body>
</html>