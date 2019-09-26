<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>LOG IN</title>
       
    </head>
    <body>			
				<form class="form-4 action="/login" method="POST">
				    <h1>Please enter your username and password</h1>
				    <p>
				        <label for="login">Login or email</label>
				        <input type="text" name="email" placeholder="Login or email" required>
				    </p>
				    <p>
				        <label for="password">Password</label>
				        <input type="password" name='password' placeholder="Password" required> 
				    </p>

				    <p>
				        <input type="submit" name="submit" value="Send">
				    </p>       
				</form>​
			<div align="center" style="padding-top: 20px; color:red" >
			${errMessage  }
			</div>
    </body>
</html>