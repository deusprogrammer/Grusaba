<%@ page import="com.ponychan.db.forum.ForumBoard" %>
<% def boards = ForumBoard.list() %>
<div class="board-menu">
	[
	<g:each in="${boards.sort{it.id}}" var="board">
	    <g:link class="board-menu" controller="forumBoard" action="board" id="${board.abbreviation.replaceAll("/", "")}">${board.abbreviation.replaceAll("/", "")}</g:link> / 
	</g:each>
	]
</div>