<%@ page import="com.team4.s4b.domain.Benefactor" %>



<div class="fieldcontain ${hasErrors(bean: benefactorInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="benefactor.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${benefactorInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: benefactorInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="benefactor.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${benefactorInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: benefactorInstance, field: 'bribePortfolios', 'error')} ">
	<label for="bribePortfolios">
		<g:message code="benefactor.bribePortfolios.label" default="Bribe Portfolios" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${benefactorInstance?.bribePortfolios?}" var="b">
    <li><g:link controller="bribePortfolio" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bribePortfolio" action="create" params="['benefactor.id': benefactorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: benefactorInstance, field: 'opportunities', 'error')} ">
	<label for="opportunities">
		<g:message code="benefactor.opportunities.label" default="Opportunities" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${benefactorInstance?.opportunities?}" var="o">
    <li><g:link controller="opportunity" action="show" id="${o.id}">${o?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="opportunity" action="create" params="['benefactor.id': benefactorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'opportunity.label', default: 'Opportunity')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: benefactorInstance, field: 'recipients', 'error')} ">
	<label for="recipients">
		<g:message code="benefactor.recipients.label" default="Recipients" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${benefactorInstance?.recipients?}" var="r">
    <li><g:link controller="recipient" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="recipient" action="create" params="['benefactor.id': benefactorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'recipient.label', default: 'Recipient')])}</g:link>
</li>
</ul>

</div>

