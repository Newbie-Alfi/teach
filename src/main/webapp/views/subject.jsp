<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Subject"%>

<!DOCTYPE html>
<html>
<link
        rel="stylesheet"
        type="text/css"
        href="css/style.css"
/>
<meta
        http-equiv="Content-Type"
        content="text/html"
        charset="UTF-8"
/>

<jsp:include page="/jspf/header.jsp" />
<div id="main">
    <section>
        <aside class="leftAside">
            <h3>Дисциплины</h3>
            <table>
                <thead>
                <tr>
                    <th scope="col">Название</th>
                    <th scope="col">Тип</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach
                        var="subject"
                        items="${subjects}"
                >
                    <tr>
                        <td>${subject.getName()}</td>
                        <td>${subject.getType()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>

    <section>
        <article>
            <h3>Введите новую дисциплину</h3>
            <div class="text-article">
                <form
                        method="POST"
                        action=""
                >
                    <p>
                        <label for="name">Название </label>
                        <input
                                type="text"
                                name="name"
                        />
                    </p>
                    <p>
                        <label for="type">Тип </label>
                        <input
                                type="text"
                                name="type"
                        />
                    </p>
                </form>
                <p>
                    <button type="submit">Добавить</button>
                </p>
            </div>
        </article>
    </section>
</div>
<jsp:include page="/jspf/footer.jsp" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</body>
</html>