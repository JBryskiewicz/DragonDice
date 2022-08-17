<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form:form modelAttribute="background" action="/background/background-editor-result" method="get">

                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="form-floating mb-3">
                                <!-- !feat name input! -->
                                <form:input path="backgroundName" cssClass="form-control" id="floatingInput"
                                            placeholder="Background Name" value="${background.backgroundName}"/>
                                <form:errors path="backgroundName" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingInput">Background Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !description input! -->
                                <form:textarea path="description" cssClass="form-control" placeholder="Description"
                                               id="floatingTextarea" cssStyle="height: 300px;" value="${background.description}"></form:textarea>
                                <form:errors path="description" cssClass="error" cssStyle="color: #bc1212"/>
                                <label for="floatingTextarea">Description</label>
                            </div>
                            <input type="hidden" name="id" value="${background.id}">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </div>

                        </form:form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Race Creator End -->

<%@include file="../_footer.jsp" %>