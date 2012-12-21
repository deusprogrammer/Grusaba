<div style="border:1px solid black; width:800px">
    <h3>New Thread</h3><br/>
    <g:form controller="forumThread" action="save">
        <label>Topic</label><g:textField name="topic" /><br/>
        <label>Email</label><g:textField name="email" /><br/>
        <label>Post</label><g:textField name="post.text" /><br/>
        <g:hiddenField name="parent.id" value="${board.id}" /><br/>
        <g:submitButton name="submit" value="Submit" /><br/>
    </g:form>
</div>