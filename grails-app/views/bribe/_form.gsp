<%@ page import="com.team4.s4b.domain.BribePortfolio; com.team4.s4b.domain.Bribe" %>



<div class="fieldcontain ${hasErrors(bean: bribeInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="bribe.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${bribeInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeInstance, field: 'probability', 'error')} required">
	<label for="probability">
		<g:message code="bribe.probability.label" default="Probability" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="probability" from="${1..99999}" class="range" required="" value="${fieldValue(bean: bribeInstance, field: 'probability')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeInstance, field: 'bribePortfolio', 'error')} required">
	<label for="bribePortfolio">
		<g:message code="bribe.bribePortfolio.label" default="Bribe Portfolio" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="bribePortfolio" name="bribePortfolio.id" from="${BribePortfolio.list()}" optionKey="id" required="" value="${bribeInstance?.bribePortfolio?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeInstance, field: 'link', 'error')} ">
	<label for="link">
		<g:message code="bribe.link.label" default="Link" />
		
	</label>
	<g:textField name="link" value="${bribeInstance?.link}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: bribeInstance, field: 'picture', 'error')} required">
	<label for="picture">
		<g:message code="bribe.picture.label" default="Picture" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="picture" name="picture" />
</div>

