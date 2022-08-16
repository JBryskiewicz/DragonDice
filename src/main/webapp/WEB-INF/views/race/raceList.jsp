<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>


        <!-- Race Window Start -->

        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <c:forEach items="${Races}" var="race">
                <div class="col-sm-12 col-md-6 col-xl-4">
                    <div class="h-100 bg-secondary rounded p-4">
                        <div class="d-flex align-items-center border-bottom py-3">
                            <div class="w-100 ms-3">
                                <div class="d-flex w-100 justify-content-between">
                                    <h6 class="mb-0">${race.raceName}</h6>
                                </div>
                                <br/>
                                <div class="d-flex align-items-center justify-content-between mb-2">
                                    <a href="/race/race-details/${race.id}">view</a>
                                    <a href="/race/race-editor/${race.id}">edit</a>
                                    <a href="/race/delete/${race.id}">delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

            <!-- Race Window End -->

<%@include file="../_footer.jsp" %>