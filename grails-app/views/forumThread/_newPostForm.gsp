<div style="border:1px solid black; width:800px">
    <h3>New Post</h3><br/>
    <g:form controller="forumPost" action="save">
        <label>Email</label><g:textField name="email" /><br/>
        <label>Post</label><g:textField name="text" /><br/>
        <g:hiddenField name="parent.id" value="${thread.id}" /><br/>
        <g:submitButton name="submit" value="Submit" /><br/>
    </g:form>
</div>