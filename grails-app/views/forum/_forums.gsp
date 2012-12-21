<%@ page import="com.ponychan.db.forum.ForumBoard" %>
<% def boards = ForumBoard.list() %>
<div class="board-menu">
	Boards:
	<g:each in="${boards.sort{it.id}}" var="board">
	    <span class="board-menu" style="border: solid black 1px"><a class="board-menu" href="${createLink(controller: 'forumBoard', action: 'show', id: board.id)}">${board.abbreviation}</a></span>
	</g:each>
</div>