<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	
	<head>
	<!-- Required? Tags -->
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Boostrap v4.5 must load before all other stylesheets -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		<style>
		
		h5 { 
			color: black; 
			align-content: center;
			font-family: Helvetica;
			font-weight: normal;
			}
			 
		.navbar-nav>li {
			float:none;
			display: inline-block;
			text-align: center;
		}
		
		
		</style>
	</head>
	
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a href="/" class="navbar-brand">
				<img 
				src="https://cdn.hipwallpaper.com/i/50/67/P2HQgW.png"
				width="30" height="30" /> Fusion Intern Project</a>
				
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
				
					<!-- Logged in User Navbar items -->
					<c:if test="${loggedin == true}">
						<li class="nav-item">
							<a href="/" class="nav-link">Sign Out</a>
					</c:if>
					
					
					<!-- Logged in Admin navbar items -->
					<c:if test="${loggedin == true && adminStatus == true}">
						<li class="nav-item">
							<a href="GridUsers" class="nav-link">All Users</a>
						</li>
					</c:if>
					
					<li class="nav-item">
					
						<c:if test="${loggedin == false}">
						<a href="SignUp" class="nav-link">New? Sign up now!</a>
						</c:if>
						
						<c:if test="${loggedin == true}">
						<a href="#" class="nav-link disabled">${email}</a>
						</c:if>
						
					</li>
					
				</ul>
			</div>
			
				
		
				
			
		</nav>
	
</html>