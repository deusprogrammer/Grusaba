<html>
	<head>
		<meta name="layout" content="board">
	</head>
	<body>
		<g:each in="${boards.sort{it.id}}" var="board">
		    <g:link class="board-menu" controller="forumBoard" action="board" id="${board.abbreviation.replaceAll("/", "")}">${board.abbreviation}</g:link><br />
		</g:each>
	</body>
</html>