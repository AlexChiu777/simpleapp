<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="home.jsp">Home</a></li>

                <c:if test="${sessionScope.user != null}">
                    <li><a href="/servicecall">Service Calls</a></li>
                </c:if>

                <c:if test="${sessionScope.user != null && sessionScope.user.type eq 'ADMIN'}">
                    <li><a href="/employee">Employees</a></li>
                </c:if>

                <li><a href="about.jsp">About</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user == null}">
                    <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <form action="/employee" method="post">
                        <input type="hidden" id="action" name="action" value="logout">
                    </form>
                    <li><a href="#" onclick="document.forms[0].submit();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
