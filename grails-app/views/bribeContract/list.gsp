
<%@ page import="com.team4.s4b.BribeContract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribeContract.label', default: 'BribeContract')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-bribeContract" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" controller="shake" action="index">SHAKE!</g:link></li>
			</ul>
		</div>
		<div id="list-bribeContract" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="bribeContract.opportunity.label" default="Opportunity" /></th>
					
						<th><g:message code="bribeContract.bribePortfolio.label" default="Bribe Portfolio" /></th>
					
						<th><g:message code="bribeContract.bribe.label" default="Bribe" /></th>
					
						<g:sortableColumn property="bribeStatus" title="${message(code: 'bribeContract.bribeStatus.label', default: 'Bribe Status')}" />
					
						<g:sortableColumn property="opportunityStatus" title="${message(code: 'bribeContract.opportunityStatus.label', default: 'Opportunity Status')}" />
					
						<g:sortableColumn property="contractStatus" title="${message(code: 'bribeContract.contractStatus.label', default: 'Contract Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${bribeContractInstanceList}" status="i" var="bribeContractInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${bribeContractInstance.id}">${fieldValue(bean: bribeContractInstance, field: "opportunity")}</g:link></td>
					
						<td>${fieldValue(bean: bribeContractInstance, field: "bribePortfolio")}</td>
					
						<td>${fieldValue(bean: bribeContractInstance, field: "bribe")}</td>
					
						<td>${fieldValue(bean: bribeContractInstance, field: "bribeStatus")}</td>
					
						<td>${fieldValue(bean: bribeContractInstance, field: "opportunityStatus")}</td>
					
						<td>${fieldValue(bean: bribeContractInstance, field: "contractStatus")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${bribeContractInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
