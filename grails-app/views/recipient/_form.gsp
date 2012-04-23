<%@ page import="com.team4.s4b.domain.BribeContract; com.team4.s4b.Recipient" %>



<div class="fieldcontain ${hasErrors(bean: recipientInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="recipient.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${recipientInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipientInstance, field: 'benefactor', 'error')} required">
	<label for="benefactor">
		<g:message code="recipient.benefactor.label" default="Benefactor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="benefactor" name="benefactor.id" from="${com.team4.s4b.Benefactor.list()}" optionKey="id" required="" value="${recipientInstance?.benefactor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipientInstance, field: 'bribeContracts', 'error')} ">
	<label for="bribeContracts">
		<g:message code="recipient.bribeContracts.label" default="Bribe Contracts" />
		
	</label>
	<g:select name="bribeContracts" from="${BribeContract.list()}" multiple="multiple" optionKey="id" size="5" value="${recipientInstance?.bribeContracts*.id}" class="many-to-many"/>
</div>

