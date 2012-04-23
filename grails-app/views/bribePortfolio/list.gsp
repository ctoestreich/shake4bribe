
<%@ page import="com.team4.s4b.BribePortfolio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribePortfolio.label', default: 'BribePortfolio')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bribePortfolio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-bribePortfolio" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'bribePortfolio.name.label', default: 'Name')}" />
					
						<th><g:message code="bribePortfolio.benefactor.label" default="Benefactor" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bribePortfolioInstanceList}" status="i" var="bribePortfolioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bribePortfolioInstance.id}">${fieldValue(bean: bribePortfolioInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: bribePortfolioInstance, field: "benefactor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bribePortfolioInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
