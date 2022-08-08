
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="_header_sidebars.jsp" %>


        <!-- Blank Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row vh-100 bg-secondary rounded align-items-center justify-content-center mx-0">
                <div class="col-md-6 text-center">
                    <h3>Confirm character delete</h3>
                    <a href="/app/character-delete-result/${userCharacter.id}" style="color: green">Confirm</a>
                    <a>   |   </a>
                    <a href="/app/select" style="color: #d41414">Cancel</a>
                </div>
            </div>
        </div>
        <!-- Blank End -->


<%@include file="_footer.jsp" %>
