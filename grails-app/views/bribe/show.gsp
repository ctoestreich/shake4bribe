
<%@ page import="com.team4.s4b.Bribe" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribe.label', default: 'Bribe')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bribe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bribe" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bribe">
			
				<g:if test="${bribeInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="bribe.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${bribeInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeInstance?.probability}">
				<li class="fieldcontain">
					<span id="probability-label" class="property-label"><g:message code="bribe.probability.label" default="Probability" /></span>
					
						<span class="property-value" aria-labelledby="probability-label"><g:fieldValue bean="${bribeInstance}" field="probability"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeInstance?.bribePortfolio}">
				<li class="fieldcontain">
					<span id="bribePortfolio-label" class="property-label"><g:message code="bribe.bribePortfolio.label" default="Bribe Portfolio" /></span>
					
						<span class="property-value" aria-labelledby="bribePortfolio-label"><g:link controller="bribePortfolio" action="show" id="${bribeInstance?.bribePortfolio?.id}">${bribeInstance?.bribePortfolio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeInstance?.link}">
				<li class="fieldcontain">
					<span id="link-label" class="property-label"><g:message code="bribe.link.label" default="Link" /></span>
					
						<span class="property-value" aria-labelledby="link-label"><g:fieldValue bean="${bribeInstance}" field="link"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeInstance?.picture}">
				<li class="fieldcontain">
					<span id="picture-label" class="property-label"><g:message code="bribe.picture.label" default="Picture" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bribeInstance?.id}" />
					<g:link class="edit" action="edit" id="${bribeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
