<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:if test="${ses.id eq null }">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Raleway:400,700');
	* {
  box-sizing: border-box;
  margin: 0;
  padding: 0; 
  font-family: Raleway, sans-serif;
}

body {
  background: linear-gradient(90deg, #C7C5F4, #776BCC);   
}

.container {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}

.screen {   
  background: linear-gradient(90deg, #5D54A4, #7C78B8);   
  position: relative; 
  height: 600px;
  width: 360px; 
  box-shadow: 0px 0px 24px #5C5696;
}

.screen__content {
  z-index: 1;
  position: relative; 
  height: 100%;
}

.screen__background {   
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 0;
  -webkit-clip-path: inset(0 0 0 0);
  clip-path: inset(0 0 0 0);  
}

.screen__background__shape {
  transform: rotate(45deg);
  position: absolute;
}

.screen__background__shape1 {
  height: 520px;
  width: 520px;
  background: #FFF; 
  top: -50px;
  right: 120px; 
  border-radius: 0 72px 0 0;
}

.screen__background__shape2 {
  height: 220px;
  width: 220px;
  background: #6C63AC;  
  top: -172px;
  right: 0; 
  border-radius: 32px;
}

.screen__background__shape3 {
  height: 540px;
  width: 190px;
  background: linear-gradient(270deg, #5D54A4, #6A679E);
  top: -24px;
  right: 0; 
  border-radius: 32px;
}

.screen__background__shape4 {
  height: 400px;
  width: 200px;
  background: #7E7BB9;  
  top: 420px;
  right: 50px;  
  border-radius: 60px;
}

.login {
  width: 320px;
  padding: 30px;
  padding-top: 156px;
}

.login__field {
  padding: 20px 0px;  
  position: relative; 
}

.login__icon {
  position: absolute;
  top: 30px;
  color: #7875B5;
}

.login__input {
  border: none;
  border-bottom: 2px solid #D1D1D4;
  background: none;
  padding: 10px;
  padding-left: 24px;
  font-weight: 700;
  width: 75%;
  transition: .2s;
}

.login__input:active,
.login__input:focus,
.login__input:hover {
  outline: none;
  border-bottom-color: #6A679E;
}

.login__submit {
  background: #fff;
  font-size: 14px;
  margin-top: 30px;
  padding: 16px 20px;
  border-radius: 26px;
  border: 1px solid #D4D3E8;
  text-transform: uppercase;
  font-weight: 700;
  display: flex;
  align-items: center;
  width: 100%;
  color: #4C489D;
  box-shadow: 0px 2px 2px #5C5696;
  cursor: pointer;
  transition: .2s;
}

.login__submit:active,
.login__submit:focus,
.login__submit:hover {
  border-color: #6A679E;
  outline: none;
}

.button__icon {
  font-size: 24px;
  margin-left: auto;
  color: #7875B5;
}

.social-login { 
  position: absolute;
  height: 140px;
  width: 160px;
  text-align: center;
  bottom: 0px;
  right: 0px;
  color: #fff;
}

.social-icons {
  display: flex;
  align-items: center;
  justify-content: center;
}

.social-login__icon {
  padding: 20px 10px;
  color: #fff;
  text-decoration: none;  
  text-shadow: 0px 0px 8px #7875B5;
}

.social-login__icon:hover {
  transform: scale(1.5);  
}
</style>
<div class="container">
  <div class="screen">
    <div class="screen__content">
      <form action="mem/login" method="post" class="login">
        <div class="login__field">
          <i class="login__icon fas fa-user"></i>
          <input type="text" name="id" class="login__input" placeholder="User ID">
        </div>
        <div class="login__field">
          <i class="login__icon fas fa-lock"></i>
          <input type="password" name="pwd" class="login__input" placeholder="Password">
        </div>
        <button type="submit" class="button login__submit">
          <span class="button__text">Log In Now</span>
          <i class="button__icon fas fa-chevron-right"></i>
        </button>       
      </form>
      <div class="social-login">
          <a href="mem/join" class="social-login__icon fab fa-facebook">
        	<h3>Join The Membership</h3>
          </a>
        <div class="social-icons">
   
        </div>
      </div>
    </div>
    <div class="screen__background">
      <span class="screen__background__shape screen__background__shape4"></span>
      <span class="screen__background__shape screen__background__shape3"></span>    
      <span class="screen__background__shape screen__background__shape2"></span>
      <span class="screen__background__shape screen__background__shape1"></span>
    </div>    
  </div>
</div>
</c:if>

<c:if test="${ses.id ne null }">

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/main.css" />
<noscript><link rel="stylesheet" href="/resources/noscript.css" /></noscript>

<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="/index.jsp" class="logo"><strong>JSP</strong> <span>project</span></a>
						<nav>
							<a href="/mem/logout">LOGOUT</a>
						</nav>
					</header>

				<!-- Menu -->
					<!-- <nav id="menu">
						<ul class="links">
							<li><a href="index.html">Home</a></li>
							<li><a href="landing.html">Landing</a></li>
							<li><a href="generic.html">Generic</a></li>
							<li><a href="elements.html">Elements</a></li>
						</ul>
						<ul class="actions stacked">
							<li><a href="#" class="button primary fit">Get Started</a></li>
							<li><a href="#" class="button fit">Log In</a></li>
						</ul>
					</nav> -->

				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
								<h1>My JSP Project</h1>
							</header>
							<div class="content">
								<p>쓸데없이 CSS를 꾸며보았다</p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">Get Started</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="/brd/register" class="link">Write a Bulletin Board</a></h3>
										<p>게시판 글쓰기</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="/brd/pageList" class="link">Bulletin List</a></h3>
										<p>게시판 리스트</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="/mem/list" class="link">Member Information</a></h3>
										<p>회원 정보</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="/mem/modify" class="link">Modify My Information</a></h3>
										<p>내 정보 수정</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">My Post</a></h3>
										<p>내가 쓴 게시글</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="/mem/logout" class="link">Log Out</a></h3>
										<p>로그 아웃</p>
									</header>
								</article>
							</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon brands alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands alt fa-facebook-f"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon brands alt fa-linkedin-in"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>
						
				
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>


</c:if>


</body>
</html>