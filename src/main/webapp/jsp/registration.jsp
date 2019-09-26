<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="css/hello.css">
</head>
<body>
<form  method="post">
      <div>

        <p>
          <label for="name">Username</label>
          <input type="text" name="name" id="name" required pattern="[A-Z][a-z]+" placeholder="Ramzes"><span></span>
        </p>
        <p>
          <label for="Email">Email</label>
          <input type="Email" name="mail" id="mail" required placeholder="example@post.com"><span></span>
        </p>
        <p>
          <label for="Password">Password</label>
          <input type="password" name="password" id="password" required placeholder="от 4 до 10 символов" minlength="4" maxlength="10"><span></span>
        </p>
        <p>
          <label for="Birthday">Birthday</label>
          <input type="text" name="birth" id="birth" placeholder="DD/MM/YYYY" ><span></span>
        </p><br/>
     <p>
          <label for="captcha">Enter the number</label><br><br>
          <span>2589</span><input type="text" name="name" id="captcha" pattern="2589" required><span></span>
        </p>

      </div>
      <footer>
        <button type="submit">REGISTRATE</button>
      </footer>
      <p>
				Already have an account? <a href="/webapp/login">Sign in</a>.
			</p>
    </form>
</body>
</html>