
<%@ page import="com.team4.s4b.Opportunity" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'opportunity.label', default: 'Opportunity')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-opportunity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-opportunity" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list opportunity">
			
				<g:if test="${opportunityInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="opportunity.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${opportunityInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${opportunityInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="opportunity.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${opportunityInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${opportunityInstance?.benefactor}">
				<li class="fieldcontain">
					<span id="benefactor-label" class="property-label"><g:message code="opportunity.benefactor.label" default="Benefactor" /></span>
					
						<span class="property-value" aria-labelledby="benefactor-label"><g:link controller="benefactor" action="show" id="${opportunityInstance?.benefactor?.id}">${opportunityInstance?.benefactor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${opportunityInstance?.bribeContracts}">
				<li class="fieldcontain">
					<span id="bribeContracts-label" class="property-label"><g:message code="opportunity.bribeContracts.label" default="Bribe Contracts" /></span>
					
						<g:each in="${opportunityInstance.bribeContracts}" var="b">
						<span class="property-value" aria-labelledby="bribeContracts-label"><g:link controller="bribeContract" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${opportunityInstance?.id}" />
					<g:link class="edit" action="edit" id="${opportunityInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
