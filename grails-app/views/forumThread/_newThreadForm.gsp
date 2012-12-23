<div style="border:1px solid black; width:800px">
    <h3>New Thread</h3><br/>
    <g:uploadForm controller="forumThread" action="save">
        <label>Topic</label><g:textField name="topic" /><br/>
        <label>Email</label><g:textField name="email" /><br/>
        <label>Post</label><g:textArea  cols="50" rows="5" name="post.text" /><br/>
        <label>File</label><g:field type="file" name="uploadFile" /><br/>
        <g:hiddenField name="parent.id" value="${board.id}" /><br/>
        <g:submitButton name="submit" value="Submit" /><br/>
    </g:uploadForm>
</div>