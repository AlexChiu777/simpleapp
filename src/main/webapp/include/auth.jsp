<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user == null}">
  <jsp:forward page="/home.jsp" />
</c:if>