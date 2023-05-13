<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Teacher"%>

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
            <h3>Преподаватели</h3>
            <table>
                <thead>
                <tr>
                    <th scope="col">ФИО</th>
                    <th scope="col">Учённое звание</th>
                    <th scope="col">Учённая степень</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach
                        var="teacher"
                        items="${teachers}"
                >
                    <tr>
                        <td>${teacher.getFullName()}</td>
                        <td>${teacher.getAcademicTitle()}</td>
                        <td>${teacher.getAcademicDegree()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </aside>
    </section>

    <section>
        <article>
            <h3>Введите нового преподавателя</h3>
            <div class="text-article">
                <form method="POST" action="">
                    <div>
                        <label for="fullName">ФИО </label>
                        <input type="text" name="fullName"/>
                    </div>
                    <div>
                        <label for="academicTitle">Учённое звание </label>
                        <input type="text" name="academicTitle"/>
                    </div>
                    <div>
                        <label for="academicDegree">Учённая степень </label>
                        <input type="text" name="academicDegree"/>
                    </div>
                    <button type="submit">Добавить</button>
                </form>
            </div>
        </article>
    </section>
</div>
<jsp:include page="/jspf/footer.jsp" />
<link rel="stylesheet" type="text/css" href="css/style.css">
</body>
</html>