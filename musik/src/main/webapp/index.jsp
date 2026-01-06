<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>music</title>
    <jsp:include page="components/allcss.jsp"/>
</head>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"/>
                <main class="container py-3">
                    <div class="container">
                        <div class="row">
                            <c:forEach var="artist" items="${artists}">
                            <div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 mb-4">
                                <div class="card artist-card h-100 shadow-sm">
                                    <img src="${artist.urlImg}" class="card-img-top"  style="height: 250px; object-fit: cover;" alt="#">
                                    <div class="card-body d-flex flex-column">
                                        <h5 class="card-title">${artist.name}</h5>
                                        <a href="view-artist?id=${artist.id}" class="action-btn view-btn">Просмотр</a>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </main>
            <jsp:include page="footer.jsp"/>
        </div>
    </body>
</html>