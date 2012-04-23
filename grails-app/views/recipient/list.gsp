
<%@ page import="com.team4.s4b.Recipient" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recipient.label', default: 'Recipient')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-recipient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-recipient" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'recipient.name.label', default: 'Name')}" />
					
						<th><g:message code="recipient.benefactor.label" default="Benefactor" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${recipientInstanceList}" status="i" var="recipientInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${recipientInstance.id}">${fieldValue(bean: recipientInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: recipientInstance, field: "benefactor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${recipientInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
