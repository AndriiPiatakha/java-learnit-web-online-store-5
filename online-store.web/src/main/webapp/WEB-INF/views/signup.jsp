<%@ taglib prefix="shop" tagdir="/WEB-INF/tags/shop"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign Up</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<shop:css-imports-main/>
	<shop:css-imports-signin/>
	
	<style>
	.error {
		color: red
	}
	</style>
</head>
<body>
	
	<shop:header/>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form class="login100-form validate-form" action="signup" modelAttribute="user" method="POST">
					<span class="login100-form-title p-b-26">
						Registration 
					</span>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter First Name">
						<form:input class="input100 has-val" path="firstName"/>
						<span class="focus-input100" data-placeholder="First Name"></span>
						<form:errors path="firstName" cssClass="error" />
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Enter Last Name">
						<form:input class="input100 has-val" path="lastName"/>
						<span class="focus-input100" data-placeholder="Last Name"></span>
						<form:errors path="lastName" cssClass="error" />
					</div>
					
					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<form:input class="input100 has-val" path="email"/>
						<span class="focus-input100" data-placeholder="Email"></span>
						<form:errors path="email" cssClass="error" />
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<form:input class="input100 has-val" path="password"/>
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Repeat password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<form:input class="input100 has-val" path="repeatPassword"/>
						<span class="focus-input100" data-placeholder="Repeat Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Sign Up
							</button>
						</div>
					</div>
					
					<c:if test="${errMsg != null}">
						<div class="container-login100-form-btn">
							<span class="txtErr">${errMsg}</span>
						</div>
					</c:if>
					<c:remove var="errMsg"/>
					

					<div class="text-center p-t-115">
						<span class="txt1">
							Already have an account?
						</span>

						<a class="txt2" href="signin">
							Sign In
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	
	<shop:footer/>
	<shop:js-imports-signin/>

</body>
</html>