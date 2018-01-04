<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 1/4/2018
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
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

private String firstName;
private String lastName;

private String phoneNumber;

private String email;
private String password;
<!--Nav bar-->
<div id="includeNav"></div>

<div class="container-fluid text-center">
  <!--left content-->
  <div class="row content">
    <div class="col-sm-4">
    </div>

    <!--Main Content-->
    <div class="col-sm-6 text-left">
      <h1>Contractor Sign Up</h1>
      <form action="#" method="post"  role="form" data-toggle="validator" >
        <div class="row">
          <div class="form-group col-xs-8">
            <label for="contractorFirstName">First Name</label>
            <input type="firstName" class="form-control" id="contractorFirstName" placeholder="Enter first name">
          </div>

          <div class="form-group col-xs-8">
            <label for="contractorLastName">Last Name</label>
            <input type="lastName" class="form-control" id="contractorLastName" placeholder="Enter last name">
          </div>

          <div class="form-group col-xs-8">
            <label for="contractorPhoneNumber">Phone Number</label>
            <input type="phoneNumber" class="form-control" id="contractorPhoneNumber" placeholder="Enter phone number">
          </div>

          <div class="form-group col-xs-8">
            <label for="contractorEmail">Email address</label>
            <input type="email" class="form-control" id="contractorEmail" aria-describedby="emailHelp" placeholder="Enter email">
            <small id="emailHelp" class="form-text text-muted">Please enter your corporate email.</small>
          </div>

          <div class="form-group col-xs-8">
            <label for="contractorPassword">Password</label>
            <input type="password" class="form-control" id="contractorPassword" placeholder="Password">
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
