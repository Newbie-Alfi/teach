<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Teacher"%>
<%
    Teacher a1 = new Teacher(
            "Аверченко Аркадий Тимофеевич",
            "Доктор Наук",
            "Доцент",
            "Преподаватель"
    );
    Teacher a2 = new Teacher(
            "Гаверченко Аркадий Тимофеевич",
            "Доктор Наук",
            "Доцент",
            "Преподаватель"
    );
    Teacher a3= new Teacher(
            "Ваверченко Аркадий Тимофеевич",
            "Доктор Наук",
            "Доцент",
            "Преподаватель"
    );
    Teacher a4 = new Teacher(
            "Шаверченко Аркадий Тимофеевич",
            "Доктор Наук",
            "Доцент",
            "Преподаватель"
    );
    Teacher[] teachers = new Teacher[]{a1, a2, a3,a4};

    int length = teachers.length;
    pageContext.setAttribute("teachers", teachers);
%>

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
                <form
                        method="POST"
                        action=""
                >
                    <div>
                        <label for="fullName">ФИО </label>
                        <input
                                type="text"
                                name="fullName"
                        />
                    </div>
                    <div>
                        <label for="academicTitle">Учённое звание </label>
                        <input
                                type="text"
                                name="email"
                        />
                    </div>
                    <div>
                        <label for="academicDegree">Учённая степень </label>
                        <input
                                type="text"
                                name="email"
                        />
                    </div>
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