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
        <div class="col-sm-4">
        </div>
        <!--Main Content-->
        <div class="col-sm-6 text-left">
            <h1>Login</h1>
            <form action="#" method="post"  role="form" data-toggle="validator" >
                <div class="row">
                    <div class="form-group col-xs-8">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>

                    <div class="form-group col-xs-8">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-xs-3">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>

                    <div class="form-group col-xs-3">
                        <a href="signup-splash.jsp" class="btn btn-link" role="button">Sign Up</a>
                    </div>
                </div>

                <%--
                <div class="form-group col-xs-4">
                    <label for="name" class="control-label col-xs-6">Email:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${employee.name}" required="true"/>

                    <label for="lastName" class="control-label col-xs-6">Password:</label>
                    <input type="text" name="lastName" id="lastName" class="form-control" value="${employee.lastName}" required="true"/>

                    <br></br>
                    <div class="row">
                        <div class="col-sm-3">
                            <button type="submit" class="btn btn-primary  btn-md">Login</button>
                        </div>
                        <div class="col-sm-7" style="margin-top: 8px;">
                            <a href="#">Sign Up</a>
                        </div>
                    </div>
                </div>--%>
            </form>
        </div>
    </div>
</div>

<!--Footer-->
<div id="includeFooter"></div>

</body>
</html>
