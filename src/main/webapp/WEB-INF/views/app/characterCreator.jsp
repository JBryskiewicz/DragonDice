<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Dragon Dice - Character Creator</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap"
          rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet"/>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
<div class="container-fluid position-relative d-flex p-0">
    <!-- Spinner Start -->
    <div id="spinner"
         class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Sidebar Start -->
    <div class="sidebar pe-4 pb-3">
        <nav class="navbar bg-secondary navbar-dark">
            <a href="#" class="navbar-brand mx-4 mb-3">
                <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>DragonDice</h3>
            </a>

            <div class="navbar-nav w-100">
                <a href="/app/select" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Characters</a>
                <a href="/app/character-creator" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Create Character</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-keyboard me-2"></i>Homebrews</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="#" class="dropdown-item">Custom Class</a>
                        <a href="#" class="dropdown-item">Custom Subclass</a>
                        <a href="#" class="dropdown-item">Custom Race</a>
                        <a href="#" class="dropdown-item">Custom Feat</a>
                        <a href="#" class="dropdown-item">Custom Background</a>
                        <a href="#" class="dropdown-item">Custom Item</a>
                        <a href="#" class="dropdown-item">Custom Spell</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <!-- Sidebar End -->


    <!-- Content Start -->
    <div class="content">
        <!-- Navbar Start -->
        <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
            <a href="#" class="sidebar-toggler flex-shrink-0">
                <i class="fa fa-bars"></i>
            </a>
            <div class="navbar-nav align-items-center ms-auto">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                        <span class="d-none d-lg-inline-flex">User</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 rounded-bottom m-0">
                        <a href="#" class="dropdown-item">My Profile</a>
                        <a href="#" class="dropdown-item">Settings</a>
                        <a href="#" class="dropdown-item">Log Out</a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->

        <!-- Character Creator -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">

                        <form action="/app/character-creator-result" method="post">

                            <div class="bg-secondary rounded h-100 p-4"><h6>Select Ability Score</h6>
                                <table class="table table-borderless">
                                    <thead>
                                    <tr>
                                        <th scope="col">STR</th>
                                        <th scope="col">DEX</th>
                                        <th scope="col">CON</th>
                                        <th scope="col">INT</th>
                                        <th scope="col">WIS</th>
                                        <th scope="col">CHA</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><div class="form-floating mb-3">
                                            <select name="strAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="dexAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="conAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="intAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="wisAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="chaAbility" aria-label="Floating label select example">
                                                <option selected value="8">8 (-1)</option>
                                                <option value="9">9 (-1)</option>
                                                <option value="10">10 (+0)</option>
                                                <option value="11">11 (+0)</option>
                                                <option value="12">12 (+1)</option>
                                                <option value="13">13 (+1)</option>
                                                <option value="14">14 (+2)</option>
                                                <option value="15">15 (+2)</option>
                                            </select>
                                        </div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">
                                        <h6>Level</h6>
                                        <div class="form-floating mb-3">
                                            <select name="charLevel" aria-label="Floating label select example">
                                                <option selected></option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="4">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                                <option value="11">11</option>
                                                <option value="12">12</option>
                                                <option value="13">13</option>
                                                <option value="14">14</option>
                                                <option value="15">15</option>
                                                <option value="16">16</option>
                                                <option value="17">17</option>
                                                <option value="18">18</option>
                                                <option value="19">19</option>
                                                <option value="20">20</option>
                                            </select>
                                        </div>
                                    </th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                                </thead>
                            </table>
                            <div class="form-floating mb-3">
                                <select name="race" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${Race}" var="race">
                                    <option value="${race.id}">${race.raceName}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your Race</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select name="feats" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${Feats}" var="feat">
                                    <option value="${feat.id}">${feat.featName}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select a Feat</label>
                            </div>
                            <div class="bg-secondary rounded h-100 p-4"><h6>Ability Score Increase</h6>
                                <table class="table table-borderless">
                                    <thead>
                                    <tr>
                                        <th scope="col">STR</th>
                                        <th scope="col">DEX</th>
                                        <th scope="col">CON</th>
                                        <th scope="col">INT</th>
                                        <th scope="col">WIS</th>
                                        <th scope="col">CHA</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><div class="form-floating mb-3">
                                            <select name="strIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="dexIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="conIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="intIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="wisIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                        <td><div class="form-floating mb-3">
                                            <select name="chaIncrease" aria-label="Floating label select example">
                                                <option selected>0</option>
                                                <option value="1">+1</option>
                                                <option value="2">+2</option>
                                            </select>
                                        </div></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </div>
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary rounded h-100 p-4">
                        <div class="bg-secondary rounded h-100 p-4">
                            <div class="form-floating mb-3">
                                <!-- !character name input! -->
                                <input type="input" name="charName" class="form-control" id="floatingInput" placeholder="Character Name">
                                <label for="floatingInput">Character Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !character age input! -->
                                <input type="input" name="charAge" class="form-control" id="floatingInput" placeholder="Character Age">
                                <label for="floatingInput">Character Age</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!-- !character backstory input! -->
                                <textarea class="form-control" name="backstory" placeholder="Backstory" id="floatingTextarea" style="height: 300px;"></textarea>
                                <label for="floatingTextarea">Backstory</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select name="charAlignment" class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <option value="Lawful Good">Lawful Good</option>
                                    <option value="Lawful Neutral">Lawful Neutral</option>
                                    <option value="Lawful Evil">Lawful Evil</option>
                                    <option value="Neutral Good">Neutral Good</option>
                                    <option value="Neutral">Neutral</option>
                                    <option value="Neutral Evil">Neutral Evil</option>
                                    <option value="Chaotic Good">Chaotic Good</option>
                                    <option value="Chaotic Neutral">Chaotic Neutral</option>
                                    <option value="Chaotic Evil">Chaotic Evil</option>
                                </select>
                                <label for="floatingSelect">Select your alignment</label>
                            </div>
                            <div class="form-floating mb-3">
                                <select class="form-select" id="floatingSelect"
                                        aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach items="${Background}" var="bGround">
                                    <option value="%${bGround.id}">${bGround.backgroundName}</option>
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Select your background</label>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Character Creator End -->

        <!-- Footer Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-secondary rounded-top p-4">
                <div class="row">
                    <div class="col-12 col-sm-6 text-center text-sm-start">
                        &copy; <a href="#">Your Site Name</a>, All Right Reserved.
                    </div>
                    <div class="col-12 col-sm-6 text-center text-sm-end">
                        <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                        Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                        <br>Distributed By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
    </div>
    <!-- Content End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/lib/chart/chart.min.js"></script>
<script src="/resources/lib/easing/easing.min.js"></script>
<script src="/resources/lib/waypoints/waypoints.min.js"></script>
<script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="/resources/lib/tempusdominus/js/moment.min.js"></script>
<script src="/resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="/resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="/resources/js/main.js"></script>
</body>

</html>