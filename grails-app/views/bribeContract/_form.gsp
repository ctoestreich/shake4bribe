<%@ page import="com.team4.s4b.domain.BribeContract" %>



<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'opportunity', 'error')} ">
	<label for="opportunity">
		<g:message code="bribeContract.opportunity.label" default="Opportunity" />
		
	</label>
	<g:select id="opportunity" name="opportunity.id" from="${com.team4.s4b.domain.Opportunity.list()}" optionKey="id" value="${bribeContractInstance?.opportunity?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribePortfolio', 'error')} required">
	<label for="bribePortfolio">
		<g:message code="bribeContract.bribePortfolio.label" default="Bribe Portfolio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bribePortfolio" name="bribePortfolio.id" from="${com.team4.s4b.domain.BribePortfolio.list()}" optionKey="id" required="" value="${bribeContractInstance?.bribePortfolio?.id}" class="many-to-one"/>
</div>
<fieldset class="embedded"><legend><g:message code="bribeContract.bribe.label" default="Bribe" /></legend>
<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.availableCount', 'error')} required">
	<label for="bribe.availableCount">
		<g:message code="bribeContract.bribe.availableCount.label" default="Available Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="availableCount" required="" value="${fieldValue(bean: bribeInstance, field: 'availableCount')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.bribePortfolio', 'error')} required">
	<label for="bribe.bribePortfolio">
		<g:message code="bribeContract.bribe.bribePortfolio.label" default="Bribe Portfolio" />
		<span class="required-indicator">*</span>
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.id', 'error')} required">
	<label for="bribe.id">
		<g:message code="bribeContract.bribe.id.label" default="Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="id" required="" value="${fieldValue(bean: bribeInstance, field: 'id')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.link', 'error')} ">
	<label for="bribe.link">
		<g:message code="bribeContract.bribe.link.label" default="Link" />
		
	</label>
	<g:textField name="link" value="${bribeInstance?.link}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.name', 'error')} required">
	<label for="bribe.name">
		<g:message code="bribeContract.bribe.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${bribeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.picture', 'error')} required">
	<label for="bribe.picture">
		<g:message code="bribeContract.bribe.picture.label" default="Picture" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="picture" name="picture" />
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.probability', 'error')} required">
	<label for="bribe.probability">
		<g:message code="bribeContract.bribe.probability.label" default="Probability" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="probability" from="${1..99999}" class="range" required="" value="${fieldValue(bean: bribeInstance, field: 'probability')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribe.version', 'error')} required">
	<label for="bribe.version">
		<g:message code="bribeContract.bribe.version.label" default="Version" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="version" required="" value="${fieldValue(bean: bribeInstance, field: 'version')}"/>
</div>
</fieldset>
<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'bribeStatus', 'error')} ">
	<label for="bribeStatus">
		<g:message code="bribeContract.bribeStatus.label" default="Bribe Status" />
		
	</label>
	<g:checkBox name="bribeStatus" value="${bribeContractInstance?.bribeStatus}" />
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'opportunityStatus', 'error')} ">
	<label for="opportunityStatus">
		<g:message code="bribeContract.opportunityStatus.label" default="Opportunity Status" />
		
	</label>
	<g:checkBox name="opportunityStatus" value="${bribeContractInstance?.opportunityStatus}" />
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'benefactor', 'error')} required">
	<label for="benefactor">
		<g:message code="bribeContract.benefactor.label" default="Benefactor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="benefactor" name="benefactor.id" from="${com.team4.s4b.domain.Benefactor.list()}" optionKey="id" required="" value="${bribeContractInstance?.benefactor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeContractInstance, field: 'recipient', 'error')} required">
	<label for="recipient">
		<g:message code="bribeContract.recipient.label" default="Recipient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="recipient" name="recipient.id" from="${com.team4.s4b.domain.Recipient.list()}" optionKey="id" required="" value="${bribeContractInstance?.recipient?.id}" class="many-to-one"/>
</div>

