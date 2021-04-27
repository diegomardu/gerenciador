<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//scriplet
String nomeEmpresa = (String)request.getAttribute("empresa");
System.out.println(nomeEmpresa);
%>
<html>
<body>
	<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<c:if test="${empty empresa }">
		Nenhuma empresa cadastrada!
	</c:if>
</body>
</html>