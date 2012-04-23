<!doctype html>
<html>
<head>
  <meta name="layout" content="main">
  <g:set var="entityName" value="${message(code: 'shake.label', default: 'Shake')}"/>
  <title><g:message code="default.list.label" args="[entityName]"/></title>
  <r:script>
    function logBribe(data, status) {
      jQuery('#updateMe').append(data + "<BR>\n");
    }
  </r:script>
</head>

<body>
<div style="padding: 5px">
  <g:link controller="bribeContract" action="list">Bribe Contracts</g:link>&nbsp;|&nbsp;<g:link controller="data" action="reset">Reset Database</g:link>
  <g:formRemote name="myForm" on404="alert('not found!')" onSuccess="logBribe(data, status)"
                url="[controller: 'shake', action: 'shake']">
    <g:hiddenField name="benefactor.id" value="${benefactor.id}" />
    Benefactor: ${benefactor.name}<br>
    Bribe Portfolio: <g:select name="bribeportfolio.id" from="${benefactor.bribePortfolios}" optionKey="id" optionValue="name"/><br>
    Recipient: <g:select name="recipient.id" from="${benefactor.recipients}" optionKey="id" optionValue="name"/><br>
    <g:submitButton name="shake" title="Shake!" value="Shake!"/>
  </g:formRemote>
  <FIELDSET style="border: 1px solid #999">
    <LEGEND><b>Bribe Log</b></LEGEND>
    <div id="updateMe" style="width:500px; min-height: 10px"></div>
  </FIELDSET>
</div>
</body>
</html>