<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Formulário de Login</title>
    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap">
</head>
<body>
    <div class="divCentral">

        <div align="center" class="divContainer">
            <h2>Login</h2>

            <s:form action="loginAction" class="loginForm" method="post">
                <s:textfield name="userName" label="Nome de Usuário"
                    class="formTextField" />
                <s:password name="password" label="Senha" class="formTextField" />
                <s:submit value="Login" class="actionBtn" />
            </s:form>
            <s:fielderror class="fielderror" fieldName="errorLogin" />
        </div>

        <div align="center" class="divContainer">
            <h2>Register</h2>

            <s:form action="registerAction" class="RegisterForm" method="post">
                <s:textfield name="userNameRegister" label="Nome de Usuário"
                    class="formTextField" />
                <s:password name="passwordRegister" label="Senha"
                    class="formTextField" />
                <s:submit value="Register" class="actionBtn" />
            </s:form>
            <s:fielderror class="fielderrorRegister"  fieldName="errorRegister" />
        </div>

    </div>
</body>
</html>
