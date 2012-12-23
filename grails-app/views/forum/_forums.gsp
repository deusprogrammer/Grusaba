<%@ page import="com.ponychan.db.forum.ForumBoard" %>
<% def boards = ForumBoard.list() %>
<div class="board-menu">
	[
	<g:each in="${boards.sort{it.id}}" var="board">
	    <a class="board-menu" href="${createLink(controller: 'forumBoard', action: 'show', id: board.id)}">${board.abbreviation}</a>
	</g:each>
	]
</div>