
<%@ page import="com.team4.s4b.BribeContract" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'bribeContract.label', default: 'BribeContract')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-bribeContract" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-bribeContract" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list bribeContract">
			
				<g:if test="${bribeContractInstance?.opportunity}">
				<li class="fieldcontain">
					<span id="opportunity-label" class="property-label"><g:message code="bribeContract.opportunity.label" default="Opportunity" /></span>
					
						<span class="property-value" aria-labelledby="opportunity-label"><g:link controller="opportunity" action="show" id="${bribeContractInstance?.opportunity?.id}">${bribeContractInstance?.opportunity?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeContractInstance?.bribePortfolio}">
				<li class="fieldcontain">
					<span id="bribePortfolio-label" class="property-label"><g:message code="bribeContract.bribePortfolio.label" default="Bribe Portfolio" /></span>
					
						<span class="property-value" aria-labelledby="bribePortfolio-label"><g:link controller="bribePortfolio" action="show" id="${bribeContractInstance?.bribePortfolio?.id}">${bribeContractInstance?.bribePortfolio?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeContractInstance?.bribe}">
				<li class="fieldcontain">
					<span id="bribe-label" class="property-label"><g:message code="bribeContract.bribe.label" default="Bribe" /></span>
					
						<span class="property-value" aria-labelledby="bribe-label"><g:fieldValue bean="${bribeContractInstance}" field="bribe"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeContractInstance?.bribeStatus}">
				<li class="fieldcontain">
					<span id="bribeStatus-label" class="property-label"><g:message code="bribeContract.bribeStatus.label" default="Bribe Status" /></span>
					
						<span class="property-value" aria-labelledby="bribeStatus-label"><g:fieldValue bean="${bribeContractInstance}" field="bribeStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeContractInstance?.opportunityStatus}">
				<li class="fieldcontain">
					<span id="opportunityStatus-label" class="property-label"><g:message code="bribeContract.opportunityStatus.label" default="Opportunity Status" /></span>
					
						<span class="property-value" aria-labelledby="opportunityStatus-label"><g:fieldValue bean="${bribeContractInstance}" field="opportunityStatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${bribeContractInstance?.contractStatus}">
				<li class="fieldcontain">
					<span id="contractStatus-label" class="property-label"><g:message code="bribeContract.contractStatus.label" default="Contract Status" /></span>
					
						<span class="property-value" aria-labelledby="contractStatus-label"><g:fieldValue bean="${bribeContractInstance}" field="contractStatus"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${bribeContractInstance?.id}" />
					<g:link class="edit" action="edit" id="${bribeContractInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
