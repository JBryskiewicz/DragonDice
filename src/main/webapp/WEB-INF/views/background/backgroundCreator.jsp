<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">
                        <form action="/background/background-creator-result">
                        <div class="bg-secondary rounded h-100 p-4">
                            <p>All fields must be filled to create background and description cannot be longer than 500 characters.</p>
                            <div class="form-floating mb-3">
                                <!-- !race name input! -->
                                <input type="input" name="backgroundName" class="form-control" id="floatingInput" placeholder="Background Name">
                                <label for="floatingInput">Background Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !features input! -->
                                <textarea class="form-control" name="description" placeholder="Description" id="floatingTextarea" style="height: 300px;"></textarea>
                                <label for="floatingTextarea">Description</label>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Race Creator End -->

<%@include file="../_footer.jsp" %>