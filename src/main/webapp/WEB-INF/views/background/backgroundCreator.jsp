<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="background" action="/background/background-creator-result" method="get">

                        <div class="bg-secondary rounded h-100 p-4">
                            <p>All fields must be filled to create background and description cannot be longer than 500 characters.</p>
                            <div class="form-floating mb-3">
                                <!-- !race name input! -->
                                <form:input path="backgroundName" cssClass="form-control" id="floatingInput" placeholder="Background Name"/>
                                <form:errors path="backgroundName" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Background Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !features input! -->
                                <form:textarea path="description" cssClass="form-control" placeholder="Description"
                                               id="floatingTextarea" cssStyle="height: 300px;"></form:textarea>
                                <form:errors path="description" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingTextarea">Description</label>
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