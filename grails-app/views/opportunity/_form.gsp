<%@ page import="com.team4.s4b.domain.Benefactor; com.team4.s4b.Opportunity" %>



<div class="fieldcontain ${hasErrors(bean: opportunityInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="opportunity.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${opportunityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: opportunityInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="opportunity.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${opportunityInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: opportunityInstance, field: 'benefactor', 'error')} required">
	<label for="benefactor">
		<g:message code="opportunity.benefactor.label" default="Benefactor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="benefactor" name="benefactor.id" from="${Benefactor.list()}" optionKey="id" required="" value="${opportunityInstance?.benefactor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: opportunityInstance, field: 'bribeContracts', 'error')} ">
	<label for="bribeContracts">
		<g:message code="opportunity.bribeContracts.label" default="Bribe Contracts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${opportunityInstance?.bribeContracts?}" var="b">
    <li><g:link controller="bribeContract" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="bribeContract" action="create" params="['opportunity.id': opportunityInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'bribeContract.label', default: 'BribeContract')])}</g:link>
</li>
</ul>

</div>

