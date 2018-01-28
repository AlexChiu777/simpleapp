<%@ page import="com.example.model.ServiceCallStatus" %>
<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 1/4/2018
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/auth.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="jquery/helper.js"></script>
    <link rel="stylesheet" href="css/test.css">

    <script>
        $(function () {
            $(".dropdown-menu li a").click(function () {
                $("#status:first-child").text($(this).text());
                $("#status:first-child").val($(this).text());
            });
        });
    </script>

</head>
<body>

<!--Nav bar-->
<div id="includeNav"></div>

<div class="container-fluid text-center">
    <!--left content-->
    <div class="row content">
        <div class="col-sm-4">
        </div>

        <!--Main Content-->
        <div class="col-sm-6 text-left">
            <h1>Service Call</h1>
            <br></br>

            <div class="row">
                <div class="form-group col-xs-8">
                    <label>Client</label><br>
                    <c:if test="${sessionScope.user.type == 'CLIENT'}">
                        ${sessionScope.user.firstName} ${sessionScope.user.lastName}
                    </c:if>

                    <c:if test="${sessionScope.user.type != 'CLIENT'}">
                        ${serviceCall.client.firstName} ${serviceCall.client.lastName}
                    </c:if>
                </div>

                <div class="form-group col-xs-8">
                    <label>Department</label><br>
                    <c:if test="${sessionScope.user.type == 'CLIENT'}">
                        ${sessionScope.user.department}
                    </c:if>

                    <c:if test="${sessionScope.user.type != 'CLIENT'}">
                        ${serviceCall.client.department}
                    </c:if>
                </div>


                <div class="form-group col-xs-8">
                    <label>Address</label><br>
                    <c:if test="${sessionScope.user.type == 'CLIENT'}">
                        ${sessionScope.user.address}
                    </c:if>

                    <c:if test="${sessionScope.user.type != 'CLIENT'}">
                        ${serviceCall.client.address}
                    </c:if>
                </div>
                <div class="form-group col-xs-8">
                    <label>Phone Number</label><br>
                    <c:if test="${sessionScope.user.type == 'CLIENT'}">
                        ${sessionScope.user.phoneNumber}
                    </c:if>

                    <c:if test="${sessionScope.user.type != 'CLIENT'}">
                        ${serviceCall.client.phoneNumber}
                    </c:if>
                </div>
            </div>

            <br></br>

            <form action="/servicecall" method="post" role="form" data-toggle="validator">
                <c:if test="${empty action}">
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="idEmployee" name="idEmployee" value="${sessionScope.user.id}">
                <input type="hidden" id="idServiceCall" name="idServiceCall" value="${serviceCall.id}">

                <div class="row">
                    <div class="form-group col-xs-8">
                        <label for="title">Issue</label>
                        <c:if test="${sessionScope.user.type == 'CLIENT'}">
                            <input type="text" class="form-control" name="title" id="title"
                                   placeholder="Enter the issue"
                                   value="${serviceCall.title}" required="true">
                        </c:if>
                        <c:if test="${sessionScope.user.type != 'CLIENT'}"><br>${serviceCall.title}</c:if>
                    </div>

                    <div class="form-group col-xs-8">
                        <label for="description">Description</label>
                        <c:if test="${sessionScope.user.type == 'CLIENT'}">
                            <input type="text" class="form-control" name="description" id="description"
                                   placeholder="Enter a description" value="${serviceCall.description}" required="true">
                        </c:if>
                        <c:if test="${sessionScope.user.type != 'CLIENT'}"><br>${serviceCall.description}</c:if>
                    </div>

                    <div class="form-group col-xs-8">
                        <label for="description">Status</label>
                        <br>

                        <c:set var="enumValues" value="<%=ServiceCallStatus.values()%>"/>
                        <c:if test="${!empty action && action eq 'edit'}">
                            <select ng-model='discussionsSelect' class='form-control' name="status">
                                <c:forEach var="status" items="${enumValues}">
                                    <c:if test="${status eq serviceCall.status}">
                                        <option value='${status}' selected="selected">${status}</option>
                                    </c:if>
                                    <c:if test="${status ne serviceCall.status}">
                                        <option value='${status}'>${status}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </c:if>

                        <c:if test="${empty action || action eq 'add'}">
                            <button type="button" class="btn btn-warning disabled">OPEN</button>
                        </c:if>
                    </div>
                </div>


                <div class="row" style="margin-top: 2%">
                    <div class="form-group col-xs-3">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>

                    <div class="form-group col-xs-3">
                        <a href="home.jsp" class="btn btn-link" role="button">Cancel</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!--Footer-->
<div id="includeFooter"></div>

</body>
</html>
