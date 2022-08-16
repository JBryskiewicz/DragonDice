<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">
                        <form action="/background/background-editor-result">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="form-floating mb-3">
                                <!-- !feat name input! -->
                                <input type="input" name="backgroundName"  class="form-control" id="floatingInput"
                                       placeholder="Background Name" value="${Background.backgroundName}">
                                <label for="floatingInput">Background Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !description input! -->
                                <textarea class="form-control" name="description" placeholder="Description"
                                          id="floatingTextarea" style="height: 300px;">${Background.description}</textarea>
                                <label for="floatingTextarea">Description</label>
                            </div>
                            <input type="hidden" name="id" value="${Background.id}">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Race Creator End -->

<%@include file="../_footer.jsp" %>