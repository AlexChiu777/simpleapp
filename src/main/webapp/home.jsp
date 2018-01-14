<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <c:if test="${requestScope.auth eq 'login'}">
                <div class="alert alert-success" role="alert">
                    Authentication Successfully!
                </div>
            </c:if>

            <c:if test="${requestScope.auth eq 'logout'}">
                <div class="alert alert-success" role="alert">
                    Logout Successfully!
                </div>
            </c:if>

            <h1>Welcome</h1>
            <p>Page still under construction.</p>
            <hr>
            <h3>Test</h3>
            <p>Lala</p>
        </div>
        <div class="col-sm-3">
        </div>
    </div>
</div>

<!--Footer-->
<div id="includeFooter"></div>


</body>
</html>
