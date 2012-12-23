<div class="new-post">
    <h3>New Post</h3><br/>
    <g:uploadForm controller="forumPost" action="save">
        <label>Email</label><g:textField class="new-post" name="email" /><br/>
        <label>Post</label><g:textArea class="new-post" cols="50" rows="5" name="text" /><br/>
        <label>File</label><g:field class="new-post" type="file" name="uploadFile" /><br/>
        <g:hiddenField name="parent.id" value="${thread.id}" /><br/>
        <g:submitButton class="new-post" name="submit" value="Submit" /><br/>
    </g:uploadForm>
</div>