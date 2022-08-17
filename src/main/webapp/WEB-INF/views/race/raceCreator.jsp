<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="race" action="/race/race-creator-result" method="get">

                        <div class="bg-secondary rounded h-100 p-4">
                            <p>All fields must be filled to create race and features cannot be longer than 500 characters.</p>
                            <div class="form-floating mb-3">
                                <!-- !race name input! -->
                                <form:input path="raceName" cssClass="form-control" id="floatingInput" placeholder="Race Name"/>
                                <form:errors path="raceName" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Race Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !walking speed input! -->
                                <form:input type="number" path="raceWalkingSpeed" cssClass="form-control" id="floatingInput" placeholder="Walking speed"/>
                                <form:errors path="raceWalkingSpeed" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Walking speed</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !features input! -->
                                <form:textarea path="raceFeatures" cssClass="form-control" placeholder="Features"
                                               id="floatingTextarea" cssStyle="height: 300px;"></form:textarea>
                                <form:errors path="raceFeatures" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingTextarea">Features</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Race Creator End -->

<%@include file="../_footer.jsp" %>