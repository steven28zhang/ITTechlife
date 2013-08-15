<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=request.getContextPath() %>/css/common/google.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<!--  -->
<div class="signin-box">
  <h2>Sign in <strong></strong></h2>
  <form novalidate="" id="gaia_loginform" action="login.do" method="post">
  <input name="continue" id="continue" value="http://www.google.com/" type="hidden">
  <input name="dsh" id="dsh" value="-927004620663910900" type="hidden">
  <input name="hl" id="hl" value="en" type="hidden">
  <input name="GALX" value="0t9pR8Pb-n0" type="hidden">
  <input id="pstMsg" name="pstMsg" value="1" type="hidden">
  <input id="dnConn" name="dnConn" value="" type="hidden">
  <input id="checkConnection" name="checkConnection" value="youtube:2917:1" type="hidden">
  <input id="checkedDomains" name="checkedDomains" value="youtube" type="hidden">
<input name="timeStmp" id="timeStmp" value="" type="hidden">
<input name="secTok" id="secTok" value="" type="hidden">
<input id="_utf8" name="_utf8" value="?" type="hidden">
  <input name="bgresponse" id="bgresponse" value="js_disabled" type="hidden">
<div class="email-div">
  <label for="Email"><strong class="email-label">UserName</strong></label>
  <input spellcheck="false" name="UserName" id="Email" value="" type="email">
</div>
<div class="passwd-div">
  <label for="Passwd"><strong class="passwd-label">Password</strong></label>
  <input name="Passwd" id="Passwd" type="password">
</div>
  <input class="g-button g-button-submit" name="signIn" id="signIn" value="Sign in" type="submit">
  <label class="remember" onclick="">
  <input name="PersistentCookie" id="PersistentCookie" value="yes" checked="checked" type="checkbox">
  <strong class="remember-label">
  Stay signed in
  </strong>
  </label>
  <input name="rmShown" value="1" type="hidden">
  </form>
  <ul>
  <li>
  <a id="link-forgot-passwd" href="https://accounts.google.com/RecoverAccount?continue=http%3A%2F%2Fwww.google.com%2F" target="_top">
  Can't access your account?
  </a>
  </li>
  </ul>
</div>
<br>
<div class="google-footer-bar">
This page is from google login page. Just as personal purpose. More info is from <a href="http://www.google.com/intl/en/policies/privacy/">google's privacy polices</a>
</div>
</body>
</html>