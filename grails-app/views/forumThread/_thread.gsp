<div class="thread">
    <h3>${thread.topic} [${thread.dateCreated}] <g:link controller="forumThread" action="show" id="${thread.id}">View</g:link></h3><br/>
    <g:each in="${thread.children.sort{it.dateCreated.getTime()}}" var="post">
        <g:render template="/forumPost/post" model="${[post: post]}"/>
    </g:each>
</div>