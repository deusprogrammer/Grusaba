<html>
<body>
    <h2>${board}</h2>
    <g:render template="newThreadForm" />
    <g:each in="${board.children.sort{it.dateCreated.getTime()}}" var="thread">
        <g:render template="thread" model="${[thread: thread]}" />
    </g:each>
</body>
</html>