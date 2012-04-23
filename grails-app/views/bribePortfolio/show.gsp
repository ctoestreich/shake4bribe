
<%@ page import="com.team4.s4b.BribePortfolio" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribePortfolio.label', default: 'BribePortfolio')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bribePortfolio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bribePortfolio" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bribePortfolio">
			
				<g:if test="${bribePortfolioInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="bribePortfolio.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${bribePortfolioInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribePortfolioInstance?.benefactor}">
				<li class="fieldcontain">
					<span id="benefactor-label" class="property-label"><g:message code="bribePortfolio.benefactor.label" default="Benefactor" /></span>
					
						<span class="property-value" aria-labelledby="benefactor-label"><g:link controller="benefactor" action="show" id="${bribePortfolioInstance?.benefactor?.id}">${bribePortfolioInstance?.benefactor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribePortfolioInstance?.bribeContracts}">
				<li class="fieldcontain">
					<span id="bribeContracts-label" class="property-label"><g:message code="bribePortfolio.bribeContracts.label" default="Bribe Contracts" /></span>
					
						<g:each in="${bribePortfolioInstance.bribeContracts}" var="b">
						<span class="property-value" aria-labelledby="bribeContracts-label"><g:link controller="bribeContract" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${bribePortfolioInstance?.bribes}">
				<li class="fieldcontain">
					<span id="bribes-label" class="property-label"><g:message code="bribePortfolio.bribes.label" default="Bribes" /></span>
					
						<g:each in="${bribePortfolioInstance.bribes}" var="b">
						<span class="property-value" aria-labelledby="bribes-label"><g:link controller="bribe" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bribePortfolioInstance?.id}" />
					<g:link class="edit" action="edit" id="${bribePortfolioInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
