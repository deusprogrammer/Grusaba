<%
	def id
	def text
	if (thread?.id != null) {
		id = thread.id
		text = "text"
	}
	else if (board?.id != null) {
		id = board.id
		text = "post.text"
	}
%>

<g:uploadForm controller="${controller}" action="save">
	<table class="new-post">
		<tbody>
			 <tr><td class="label">Name</td><td><g:textField class="new-post" name="name" /></td></tr>
		     <tr><td class="label">Email</td><td><g:textField class="new-post" name="email" /></td></tr>
		     <tr><td class="label">Subject</td><td><g:textField class="new-post" name="topic" /><g:submitButton class="new-post" name="submit" value="Submit" /></td></tr>
		     <tr><td class="label">Post</td><td><g:textArea class="new-post" cols="50" rows="5" name="${text}" /></td></tr>
		     <tr><td class="label">File</td><td><g:field class="new-post" type="file" name="uploadFile" /></td></tr>
		     <g:hiddenField name="parent.id" value="${id}" /><br/>
		</tbody>
    </table>
</g:uploadForm>