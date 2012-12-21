<div style="border:1px solid black; width:800px">
    <h3>New Post</h3><br/>
    <g:uploadForm controller="forumPost" action="save">
        <label>Email</label><g:textField name="email" /><br/>
        <label>Post</label><g:textArea name="text" /><br/>
        <label>File</label><g:field type="file" name="uploadFile" /><br/>
        <g:hiddenField name="parent.id" value="${thread.id}" /><br/>
        <g:submitButton name="submit" value="Submit" /><br/>
    </g:uploadForm>
</div>