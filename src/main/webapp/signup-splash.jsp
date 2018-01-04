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
    <div class="col-sm-6 text-center">
      <div class="col-xs-12" style="margin-bottom: 10%">
        <h1>Are you a Contractor or Client?</h1>
      </div>

        <div class="row">
          <div class="form-group col-xs-6">
            <a href="signup-contractor.jsp" class="btn btn-primary btn-lg btn-block" role="button"><h2>Contractor</h2></a>
          </div>

          <div class="form-group col-xs-6">
            <a href="signup-client.jsp" class="btn btn-secondary btn-lg btn-block" role="button"><h2>Client</h2></a>
          </div>
        </div>
    </div>
    <div class="col-sm-3">
    </div>
  </div>
</div>

<!--Footer-->
<div id="includeFooter"></div>

</body>
</html>
