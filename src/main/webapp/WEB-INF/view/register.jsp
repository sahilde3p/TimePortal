<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body>
		<div class="container">
			<h5 class="display-3 text-center my-4">Send Invite</h5>
			<div class='row'>
				<div class="offset-3"></div>
				<div class="col-md-6">
				<form action='' method='post' model="AuthPayload">
					<div class="form-group">
						<label for="company">Company Name: </label>
						<input type="text" class='form-control' name="companyName"/>
					</div>
					<div class="form-group">
						<label for="company">Email: </label>
						<input type="text" class='form-control' name="email"/>
					</div>
					<div class="form-group">
						<label for="company">Password: </label>
						<input type="password" class='form-control' name="password"/>
					</div>
					<div class="form-group">
						<label for="company">Confirm Password: </label>
						<input type="password" class='form-control' name="confirmPassword"/>
					</div>
					<input type="submit" class='btn btn-success' value="Register"/>
				</form>
				</div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>