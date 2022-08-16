<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../_header_sidebars.jsp" %>

        <!-- Race Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">
                        <form action="/race/race-editor-result">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="form-floating mb-3">
                                <!-- !race name input! -->
                                <input type="input" name="raceName"  class="form-control" id="floatingInput"
                                       placeholder="Race Name" value="${Race.raceName}">
                                <label for="floatingInput">Race Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !walking speed input! -->
                                <input type="input" name="raceWalkingSpeed"  class="form-control" id="floatingInput"
                                       placeholder="Walking speed" value="${Race.raceWalkingSpeed}">
                                <label for="floatingInput">Walking speed</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !features input! -->
                                <textarea class="form-control" name="raceFeatures"
                                          placeholder="Features" id="floatingTextarea" style="height: 300px;">${Race.raceFeatures}</textarea>
                                <label for="floatingTextarea">Features</label>
                            </div>
                            <input type="hidden" name="id" value="${Race.id}">
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Race Creator End -->

<%@include file="../_footer.jsp" %>