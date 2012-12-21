<label>Name:</label><g:textField name="name" value="${board?.name}"/><br/>
<label>Abbreviation:</label><g:textField name="abbreviation" value="${board?.abbreviation}"/>
<g:hiddenField name="parent.id" value="${forum? forum?.id : board?.forum.id}" />