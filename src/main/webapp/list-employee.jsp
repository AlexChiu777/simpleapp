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
</head>
<body>
<!--Nav bar-->
<div id="includeNav"></div>

<div class="container-fluid text-center">
    <!--left content-->
    <div class="row content">
        <div class="col-sm-3">
        </div>
        <!--Main Content-->
        <div class="col-sm-6 text-left">
            <h2>Employee</h2>
            <!--Search Form -->
            <form action="/employee" method="get" id="searchEmployeeForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="employeeName" id="employeeName" class="form-control" required="true" placeholder="Type the Name or Last Name of the employee"/>
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
            </form>

            <!--Employees List-->
            <c:if test="${not empty message}">
                <div class="alert alert-success">
                        ${message}
                </div>
            </c:if>
            <form action="/employee" method="post" id="employeeForm" role="form" >
                <input type="hidden" id="idEmployee" name="idEmployee">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty employeeList}">
                        <table  class="table table-striped">
                            <thead>
                            <tr>
                                <td>#</td>
                                <td>First Name</td>
                                <td>Last Name</td>
                                <td>Type</td>
                                <td>Department</td>
                                <td>Role</td>
                                <td>Address</td>
                                <td>Phone Number</td>
                                <td>E-mail</td>
                                <td></td>
                            </tr>
                            </thead>
                            <c:forEach var="employee" items="${employeeList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${idEmployee == employee.id}">
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="/employee?idEmployee=${employee.id}&searchAction=searchById">${employee.id}</a>
                                    </td>
                                    <td>${employee.firstName}</td>
                                    <td>${employee.lastName}</td>
                                    <td>${employee.type}</td>

                                    <c:if test="${employee.type == 'CLIENT'}">
                                        <td>${employee.department}</td>
                                        <td>${employee.role}</td>
                                    </c:if>

                                    <c:if test="${employee.type != 'CLIENT'}">
                                        <td></td>
                                        <td></td>
                                    </c:if>

                                    <td>${employee.address}</td>
                                    <td>${employee.phoneNumber}</td>
                                    <td>${employee.email}</td>
                                    <td><a href="#" id="remove"
                                           onclick="document.getElementById('action').value = 'remove';document.getElementById('idEmployee').value = '${employee.id}';

                                                   document.getElementById('employeeForm').submit();">
                                        <span class="glyphicon glyphicon-trash"/>
                                    </a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <br>
                        <div class="alert alert-info">
                            No employee found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
        <div class="col-sm-3">
        </div>
    </div>
</div>

<!--Footer-->
<div id="includeFooter"></div>


</body>
</html>

