<html>
<body>
    <g:render template="newPostForm" />
    <div style="border:1px solid black; width:800px">
        <h3>${thread.topic} [${thread.dateCreated}]</h3><br/>
        <g:each in="${thread.children.sort{it.dateCreated.getTime()}}" var="post">
            <g:render template="post" model="${[post: post]}"/>
        </g:each>
    </div>
</body>
</html>