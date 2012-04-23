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
  <g:link controller="benefactor" action="list">Manage Data</g:link>&nbsp;|&nbsp;<g:link controller="bribeContract" action="list">Bribe Contracts</g:link>&nbsp;|&nbsp;<g:link controller="data" action="reset">Reset Database</g:link>
  <g:formRemote name="myForm" on404="alert('not found!')" onSuccess="logBribe(data, status)"
                url="[controller: 'shake', action: 'shake']">
    <g:hiddenField name="benefactor.id" value="${benefactor.id}"/>
    <BR><br>
    Benefactor: ${benefactor.name}<br>
    Bribe Portfolio: <g:select name="bribeportfolio.id" from="${benefactor.bribePortfolios}" optionKey="id" optionValue="name"/><br>
    Recipient: <g:select name="recipient.id" from="${benefactor.recipients}" optionKey="id" optionValue="name"/><br>
    Opportunity: <g:select name="opportunity.id" from="${benefactor.opportunities}" optionKey="id" optionValue="name"/><br>
    <BR><BR>

    <p align="center"><g:submitButton style="width:150px; height: 50px" name="shake" title="Shake" value="  Shake!  "/></p>
  </g:formRemote>
  <FIELDSET style="border: 1px solid #999">
    <LEGEND><b>Bribe Log</b></LEGEND>

    <div id="updateMe" style="width:500px; min-height: 10px"></div>
  </FIELDSET>
</div>
</body>
</html>