<html>
	<head>
		<meta name="layout" content="main">
	</head>
	<body>
		<g:each in="${boards.sort{it.id}}" var="board">
		    <a href="${createLink(controller: 'forumBoard', action: 'show', id: board.id)}">${board}</a><br/>
		</g:each>
	</body>
</html>