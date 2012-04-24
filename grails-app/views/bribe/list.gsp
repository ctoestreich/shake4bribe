
<%@ page import="com.team4.s4b.domain.Bribe" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribe.label', default: 'Bribe')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bribe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bribe" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'bribe.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="probability" title="${message(code: 'bribe.probability.label', default: 'Probability')}" />
					
						<g:sortableColumn property="availableCount" title="${message(code: 'bribe.availableCount.label', default: 'Available Count')}" />
					
						<th><g:message code="bribe.bribePortfolio.label" default="Bribe Portfolio" /></th>
					
						<g:sortableColumn property="link" title="${message(code: 'bribe.link.label', default: 'Link')}" />
					
						<g:sortableColumn property="picture" title="${message(code: 'bribe.picture.label', default: 'Picture')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bribeInstanceList}" status="i" var="bribeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bribeInstance.id}">${fieldValue(bean: bribeInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: bribeInstance, field: "probability")}</td>
					
						<td>${fieldValue(bean: bribeInstance, field: "availableCount")}</td>
					
						<td>${fieldValue(bean: bribeInstance, field: "bribePortfolio")}</td>
					
						<td>${fieldValue(bean: bribeInstance, field: "link")}</td>
					
						<td>${fieldValue(bean: bribeInstance, field: "picture")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bribeInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
