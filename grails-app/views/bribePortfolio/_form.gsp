<%@ page import="com.team4.s4b.domain.BribePortfolio" %>



<div class="fieldcontain ${hasErrors(bean: bribePortfolioInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="bribePortfolio.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${bribePortfolioInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribePortfolioInstance, field: 'benefactor', 'error')} required">
	<label for="benefactor">
		<g:message code="bribePortfolio.benefactor.label" default="Benefactor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="benefactor" name="benefactor.id" from="${com.team4.s4b.Benefactor.list()}" optionKey="id" required="" value="${bribePortfolioInstance?.benefactor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribePortfolioInstance, field: 'bribeContracts', 'error')} ">
	<label for="bribeContracts">
		<g:message code="bribePortfolio.bribeContracts.label" default="Bribe Contracts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${bribePortfolioInstance?.bribeContracts?}" var="b">
    <li><g:link controller="bribeContract" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bribeContract" action="create" params="['bribePortfolio.id': bribePortfolioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bribeContract.label', default: 'BribeContract')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: bribePortfolioInstance, field: 'bribes', 'error')} ">
	<label for="bribes">
		<g:message code="bribePortfolio.bribes.label" default="Bribes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${bribePortfolioInstance?.bribes?}" var="b">
    <li><g:link controller="bribe" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bribe" action="create" params="['bribePortfolio.id': bribePortfolioInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bribe.label', default: 'Bribe')])}</g:link>
</li>
</ul>

</div>

