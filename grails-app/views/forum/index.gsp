<html>
<body>
<g:each in="${boards.sort{it.id}}" var="board">
    ${board}<br/>
</g:each>
</body>
</html>