<div class="new-post">
    <h3>New Post</h3><br/>
    <g:uploadForm controller="forumThread" action="save">
        <label>Topic</label><g:textField class="new-post" name="topic" /><br/>
        <label>Email</label><g:textField class="new-post" name="email" /><br/>
        <label>Post</label><g:textArea class="new-post" cols="50" rows="5" name="post.text" /><br/>
        <label>File</label><g:field type="file" name="uploadFile" /><br/>
        <g:hiddenField name="parent.id" value="${board.id}" /><br/>
        <g:submitButton class="new-post" name="submit" value="Submit" /><br/>
    </g:uploadForm>
</div>