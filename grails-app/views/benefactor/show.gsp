
<%@ page import="com.team4.s4b.domain.Benefactor" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'benefactor.label', default: 'Benefactor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-benefactor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-benefactor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list benefactor">
			
				<g:if test="${benefactorInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="benefactor.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${benefactorInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${benefactorInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="benefactor.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${benefactorInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${benefactorInstance?.bribePortfolios}">
				<li class="fieldcontain">
					<span id="bribePortfolios-label" class="property-label"><g:message code="benefactor.bribePortfolios.label" default="Bribe Portfolios" /></span>
					
						<g:each in="${benefactorInstance.bribePortfolios}" var="b">
						<span class="property-value" aria-labelledby="bribePortfolios-label"><g:link controller="bribePortfolio" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${benefactorInstance?.opportunities}">
				<li class="fieldcontain">
					<span id="opportunities-label" class="property-label"><g:message code="benefactor.opportunities.label" default="Opportunities" /></span>
					
						<g:each in="${benefactorInstance.opportunities}" var="o">
						<span class="property-value" aria-labelledby="opportunities-label"><g:link controller="opportunity" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${benefactorInstance?.recipients}">
				<li class="fieldcontain">
					<span id="recipients-label" class="property-label"><g:message code="benefactor.recipients.label" default="Recipients" /></span>
					
						<g:each in="${benefactorInstance.recipients}" var="r">
						<span class="property-value" aria-labelledby="recipients-label"><g:link controller="recipient" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${benefactorInstance?.id}" />
					<g:link class="edit" action="edit" id="${benefactorInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
