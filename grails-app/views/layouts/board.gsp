<html>
	<head>
		<title><g:layoutTitle default="XChan" /></title>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'board.css')}" type="text/css">
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="${resource(dir: 'js', file: 'board.js')}"></script>
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<g:render template="/forum/forums" />
		<g:if test="${flash.message}">
			<div class="flash-message">
				<g:message code="${flash.message}" />
				<button class="flash-message">Okay</button>
			</div>
		</g:if>
		<g:layoutBody/>
		<r:layoutResources />
	</body>
</html>