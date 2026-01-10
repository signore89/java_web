<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Вход</title>
    <jsp:include page="components/allcss.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="height">
    <section class="form">
        <h2>Авторизация пользователя</h2>

        <c:if test="${not empty succMsg}">
            <p class="center text-success fs-3">${succMsg}</p>
            <c:remove var="succMsg" scope="session" />
        </c:if>
        <c:if test="${not empty errorMsg}">
            <p class="center text-danger fs-3">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session" />
        </c:if>

        <form action="userLogin" method="post">
            <div>
                <label for="email-address">Имя</label>
                <input type="text" name="name" class="form-control" id="name" required>
            </div>
            <div>
                <label for="psw">Пароль:</label>
                <input type="password" name="password" class="form-control" id="psw" required>
            </div>
            <button class="btn button">Авторизация</button>
        </form>
        <p class="center">У Вас нет аккаунта? <a href="signup.jsp" class="text-decoration-none">Создать аккаунт</a></p>
    </section>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>