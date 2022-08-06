<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DragonDice - Character Sheet</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="/resources/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
<div class="container-fluid position-relative d-flex p-0">
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
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
            <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
            </a>
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

        <!-- Abilities block Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">

                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col">STR</th><th scope="col">DEX</th><th scope="col">CON</th>
                                    <th scope="col">INT</th><th scope="col">WIS</th><th scope="col">CHA</th>
                                    <th scope="col">Initiative</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>${userCharacter.strAbility}</td><td>${userCharacter.dexAbility}</td>
                                    <td>${userCharacter.conAbility}</td><td>${userCharacter.intAbility}</td>
                                    <td>${userCharacter.wisAbility}</td><td>${userCharacter.chaAbility}</td>
                                    <%-- Initiative counted from DEX modifier, reminder to make logic for that --%>
                                    <td><button type="button" class="btn btn-danger m-2">+4</button></td>
                                </tr>
                                <tr>
                                    <%-- Make logic for modifiers so they can be displayed! --%>
                                    <td><button type="button" class="btn btn-danger m-2">-1</button></td>
                                    <td><button type="button" class="btn btn-danger m-2">+4</button></td>
                                    <td><button type="button" class="btn btn-danger m-2">+3</button></td>
                                    <td><button type="button" class="btn btn-danger m-2">-1</button></td>
                                    <td><button type="button" class="btn btn-danger m-2">+2</button></td>
                                    <td><button type="button" class="btn btn-danger m-2">+0</button></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Abilities block end -->

                <!-- Basics (HP, walking) Start -->
                <div class="col-sm-12 col-xl-6">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <table class="table table-borderless">
                                <thead>
                                <tr>
                                    <th scope="col">Proficiency</th><th scope="col">Walking</th><th scope="col">Hit Points</th>
                                    <th scope="col">Modify:</th>
                                    <th scope="col"><button type="button" class="btn btn-danger m-2">plus</button></th>
                                    <th scope="col"><button type="button" class="btn btn-danger m-2">minus</button></th>
                                    <th>Armor Class</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>+3</td><td>30ft</td><td>29 / 51</td>
                                    <td><form><input name="health" type="text" class="form-control"></form></td>
                                    <td></td><td></td><td>15</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Basics end -->

        <!-- Skills and saving throws -->
        <div class="container-fluid pt-4 px-4">
            <div class="row g-4">
                <div class="col-sm-6 col-xl-3">
                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                        <div class="ms-3">
                            <table class="table">
                                <thead>
                                <tr><th scope="col">Saving Throws</th><th scope="col">Modifier</th></tr>
                                </thead>
                                <tbody>
                                <!-- Logic for modifiers + proficiency --->
                                <tr><td>Strength</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Dexterity</td><td><button type="button" class="btn btn-danger m-2">+7</button></td></tr>
                                <tr><td>Constitution</td><td><button type="button" class="btn btn-danger m-2">+3</button></td></tr>
                                <tr><td>Intelligence</td><td><button type="button" class="btn btn-danger m-2">+2</button></td></tr>
                                <tr><td>Wisdom</td><td><button type="button" class="btn btn-danger m-2">+2</button></td></tr>
                                <tr><td>Charisma</td><td><button type="button" class="btn btn-danger m-2">+0</button></td></tr>
                                </tbody>
                            </table>

                            <br/><br/>

                            <table class="table">
                                <thead>
                                <tr><th scope="col">Passive Senses</th><th scope="col">Roll</th></tr>
                                </thead>
                                <tbody>
                                <tr><td>Perception</td><td>18</td></tr>
                                <tr><td>Investigation</td><td>9</td></tr>
                                <tr><td>Insight</td><td>18</td></tr>
                                </tbody>
                            </table>

                            <br/><br/>

                            <table class="table">
                                <thead>
                                <tr><th scope="col">Proficiencies</th><th scope="col"></th></tr>
                                </thead>
                                <tbody>
                                <tr><td>Armor:</td><td>Light</td></tr>
                                <tr><td>Weapons:</td><td>Simple, Crossbows, Rapier, longsword, Hand</td></tr>
                                <tr><td>Tools:</td><td>Thieves' Tools, Poisoner kit, Playing Cards Set</td></tr>
                                <tr><td>Languages:</td><td>Common, Goblin, Undercommon</td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 col-xl-3">
                    <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                        <div class="ms-3">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Skill</th><th scope="col">Modifier</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr><td>Acrobatics</td><td><button type="button" class="btn btn-danger m-2">+7</button></td></tr>
                                <tr><td>Animal Handling</td><td><button type="button" class="btn btn-danger m-2">+2</button></td></tr>
                                <tr><td>Arcana</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Athletics</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Deception</td><td><button type="button" class="btn btn-danger m-2">+6</button></td></tr>
                                <tr><td>History</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Insight</td><td><button type="button" class="btn btn-danger m-2">+8</button></td></tr>
                                <tr><td>Intimidation</td><td><button type="button" class="btn btn-danger m-2">+3</button></td></tr>
                                <tr><td>Investigation</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Medicine</td><td><button type="button" class="btn btn-danger m-2">+2</button></td></tr>
                                <tr><td>Nature</td><td><button type="button" class="btn btn-danger m-2">+5</button></td></tr>
                                <tr><td>Perception</td><td><button type="button" class="btn btn-danger m-2">+8</button></td></tr>
                                <tr><td>Performance</td><td><button type="button" class="btn btn-danger m-2">+0</button></td></tr>
                                <tr><td>Persuasion</td><td><button type="button" class="btn btn-danger m-2">+0</button></td></tr>
                                <tr><td>Religion</td><td><button type="button" class="btn btn-danger m-2">-1</button></td></tr>
                                <tr><td>Sleight of Hand</td><td><button type="button" class="btn btn-danger m-2">+4</button></td></tr>
                                <tr><td>Stealth</td><td><button type="button" class="btn btn-danger m-2">+10</button></td></tr>
                                <tr><td>Survival</td><td><button type="button" class="btn btn-danger m-2">+8</button></td></tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Skills and saving throws end-->

        <!-- Footer Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-secondary rounded-top p-4">
                <div class="row">
                    <div class="col-12 col-sm-6 text-center text-sm-start">
                        &copy; <a href="#">DragonDice</a>, All Right Reserved.
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