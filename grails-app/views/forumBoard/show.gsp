<html>
<body>
    <h2>${board}</h2>
    <g:render template="newThreadForm" />
    <g:each in="${board.children.sort{it.dateCreated.getTime()}}" var="thread">
        <g:render template="/forumThread/thread" model="${[thread: thread]}" />
    </g:each>
</body>
</html>