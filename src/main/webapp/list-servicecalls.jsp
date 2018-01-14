<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/auth.jsp"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>

  <script type="text/javascript" src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
  <script type="text/javascript" charset="utf-8">
    $(document).ready(function() {
      $('#serviceCallTable').DataTable();
    } );
  </script>

  <script src="jquery/helper.js"></script>
  <link rel="stylesheet" href="css/test.css">
</head>
<body>
<!--Nav bar-->
<div id="includeNav"></div>

<div class="container-fluid text-center">
  <!--left content-->
  <div class="row content">
    <div class="col-sm-2">
    </div>
    <!--Main Content-->
    <div class="col-sm-8 text-left">
      <h2>ServiceCall</h2>

      <br></br>
      <!--ServiceCalls List-->
      <c:if test="${not empty message}">
        <div class="alert alert-success">
            ${message}
        </div>
      </c:if>
      <form action="/serviceCall" method="post" id="serviceCallForm" role="form" >
        <input type="hidden" id="idServiceCall" name="idServiceCall">
        <input type="hidden" id="action" name="action">

        <div class="table-responsive">
              <c:choose>
              <c:when test="${not empty serviceCallList}">
                <table id="serviceCallTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
                  <thead>
                  <tr>
                    <th>#</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Client ID</th>
                    <th>Client First Name</th>
                    <th>Client Last Name</th>
                    <th>Client Department</th>
                    <th>Client Role</th>
                    <th>Client Address</th>
                    <th>Client Phone Number</th>
                    <th>Client E-mail</th>
                  </tr>
                  </thead>

                  <tbody>
                    <c:forEach var="serviceCall" items="${serviceCallList}">
                      <c:set var="classSucess" value=""/>
                      <c:if test ="${idServiceCall == serviceCall.id}">
                        <c:set var="classSucess" value="info"/>
                      </c:if>

                      <tr class="${classSucess}">
                        <td>
                          <%--<a href="/serviceCall?idServiceCall=${serviceCall.id}&searchAction=searchById">${serviceCall.id}</a>--%>
                              ${serviceCall.id}
                        </td>
                        <td>${serviceCall.title}</td>
                        <td>${serviceCall.description}</td>
                        <td>
                            <c:if test="${serviceCall.status eq 'OPEN'}">
                              <span class="btn btn-primary">${serviceCall.status}</span>
                            </c:if>

                            <c:if test="${serviceCall.status eq 'ACCEPTED'}">
                              <span class="btn btn-warning">${serviceCall.status}</span>
                            </c:if>

                            <c:if test="${serviceCall.status eq 'COMPLETE'}">
                              <span class="btn btn-success">${serviceCall.status}</span>
                            </c:if>

                            <c:if test="${serviceCall.status eq 'INCOMPLETE'}">
                              <span class="btn btn-danger">${serviceCall.status}</span>
                            </c:if>
                        </td>
                        <td>${serviceCall.client.id}</td>
                        <td>${serviceCall.client.firstName}</td>
                        <td>${serviceCall.client.lastName}</td>
                        <td>${serviceCall.client.department}</td>
                        <td>${serviceCall.client.role}</td>
                        <td>${serviceCall.client.address}</td>
                        <td>${serviceCall.client.phoneNumber}</td>
                        <td>${serviceCall.client.email}</td>
                        <%--<td><a href="#" id="remove"
                               onclick="document.getElementById('action').value = 'remove';document.getElementById('idServiceCall').value = '${serviceCall.id}';

                                       document.getElementById('serviceCallForm').submit();">
                          <span class="glyphicon glyphicon-trash"/>
                        </a>

                        </td>--%>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </c:when>
              <c:otherwise>
                <br>
                <div class="alert alert-info">
                  No serviceCall found matching your search criteria
                </div>
              </c:otherwise>
            </c:choose>
          </div>
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


