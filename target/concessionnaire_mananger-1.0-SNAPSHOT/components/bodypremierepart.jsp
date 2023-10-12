<%-- 
    Document   : bodypremierepart
    Created on : 16 sept. 2023, 16:16:12
    Author     : CamiloM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body id="page-top">
    
    <!-- Valider notre session--> <!-- request la sesion qui nous a ammené jusqu'à ici -->
    <!--2. l_attribute EmailLog vient deSvLogin  dans la creation de la session -->
    <% HttpSession misession = request.getSession();
        String employeeSession = (String)request.getSession().getAttribute("EmailLog");
        //verifie si le log est correct - si cest correct laisse passer
        if(employeeSession == null){
            response.sendRedirect("noLogin.jsp");   //à creer noLogin
        }
 
    %>    
    
    
    

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion " id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                <div class="sidebar-brand-icon rotate-n-0">
                    <i class="fas fa-brands fa-opencart-alt" style="color: #d4d7de;"></i>
                </div>
                
                <div class="sidebar-brand-text mx-3">Concession Automobil AutoFuture<sup></sup></div>
            </a>
            
            

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - TABLEAU DE CONTROLE -->
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">  
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>TABLEAU DE CONTROLE</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading Separador Modules-->
            <div class="sidebar-heading">
                Modules
            </div>

            <!-- Etat des Stocks Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseStocks"
                    aria-expanded="true" aria-controls="collapseStocks">
                    <!--i class="fas fa-fw fa-cog"></i-->
                    <i class="fas fa-fw fa-car-side"></i>
                    <span>Etat des Stocks</span>
                </a>
                <div id="collapseStocks" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Gestion des stocks:</h6>
                         <!--ici on gère les butons du collapse-->
                        <a class="collapse-item" href="chargeVoiture.jsp">Charger unité</a>
                        <a class="collapse-item" href="SvProduct">Consulter Stocks</a>
<!--                        <a class="collapse-item" href="cards.html">Modifier unité</a>-->
                    </div>
                </div>
            </li>
            <!-- Offices Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseAgences"
                    aria-expanded="true" aria-controls="collapseAgences">
                    <i class="fas fa-fa fa-building"></i>
                    <span>Agences</span>
                </a>
                <!--ici on gère les butons du collapse-->
                <div id="collapseAgences" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Gestion d'agences</h6>
                        <!--ici on gère les butons du collapse-->
                        <a class="collapse-item" href="SvOffice">Consulter Etat d'agence</a>
                        <a class="collapse-item" href="chargeOffice.jsp">Ajouter nouvelle agence</a>
<!--                        <a class="collapse-item" href="utilities-animation.html">Modiifer agence</a>
                        <a class="collapse-item" href="utilities-other.html">Supprimer agence</a>-->
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Gestion 
            </div>

            <!-- Ressources Humaines Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseRh"
                    aria-expanded="true" aria-controls="collapseRh">
                    <i class="fas fa-solid fa-snowflake"></i>
                    <span>Ressources Humaines</span>
                </a>
                <div id="collapseRh" class="collapse" aria-labelledby="headingRh" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Ressources Humaines</h6>
                        <a class="collapse-item" href="SvEmployee">Ensemble de personnel</a>
                        <a class="collapse-item" href="chargeEmployee.jsp">Nouveau collaborateur</a>
                    </div>
                </div>
            </li>

            <!-- Item - Clients -->
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseClts"
                    aria-expanded="true" aria-controls="collapseClts">
                     <i class="fas fa-fa fa-stopwatch-20"></i>
                    <span>Clients</span>
                </a>
                <div id="collapseClts" class="collapse" aria-labelledby="headingRh" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Gestion des Clients</h6>
                        <a class="collapse-item" href="SvCustomer">Consulter Base Clients</a>
                        <a class="collapse-item" href="chargeCustomer.jsp">Ajouter nouveau client</a>
<!--                        <a class="collapse-item" href="utilities-animation.html">Modifer client</a>
                        <a class="collapse-item" href="utilities-other.html">Supprimer client</a>-->
                    </div>
                </div>
            </li>

            <!-- Nav Item - Orders -->
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#collapseOrds"
                   aria-expanded="true" aria-controls="collapseOrds">
                    <i class="fas fa-fa fa-money-bill"></i>
                    <span>Commandes</span>
                </a>
                <div id="collapseOrds" class="collapse" aria-labelledby="headingOrds" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Gestion des Commandes</h6>
                        <a class="collapse-item" href="utilities-color.html">Historique commandes</a>
                        <a class="collapse-item" href="utilities-border.html">Nouvelle commande</a>
<!--                        <a class="collapse-item" href="utilities-animation.html">Modifer commande</a>
                        <a class="collapse-item" href="utilities-other.html">Supprimer commande</a>-->
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <!-- Barre de recherche effacée  -->


                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <!-- id="searchDropdown EFFACEE  -->
                         
<!--                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                             Dropdown - Messages 
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>-->

                        <!-- Nav Item - Alerts -->
                        <!-- id="alertsDropdown" EFFACEE  -->
                        
<!--                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-bell fa-fw"></i>
                                 Counter - Alerts 
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                             Dropdown - Alerts 
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="alertsDropdown">
                                <h6 class="dropdown-header">
                                    Alerts Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-primary">
                                            <i class="fas fa-file-alt text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 12, 2019</div>
                                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-success">
                                            <i class="fas fa-donate text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 7, 2019</div>
                                        $290.29 has been deposited into your account!
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="mr-3">
                                        <div class="icon-circle bg-warning">
                                            <i class="fas fa-exclamation-triangle text-white"></i>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="small text-gray-500">December 2, 2019</div>
                                        Spending Alert: We've noticed unusually high spending for your account.
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                            </div>
                        </li>-->

                        <!-- Nav Item - Messages -->
                        <!-- id="messagesDropdown" EFFACEE  -->
                        
<!--                        <li class="nav-item dropdown no-arrow mx-1">
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-fw"></i>
                                 Counter - Messages 
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                             Dropdown - Messages 
                            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="messagesDropdown">
                                <h6 class="dropdown-header">
                                    Message Center
                                </h6>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div class="font-weight-bold">
                                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                            problem I've been having.</div>
                                        <div class="small text-gray-500">Emily Fowler Â· 58m</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                            alt="...">
                                        <div class="status-indicator"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">I have the photos that you ordered last month, how
                                            would you like them sent to you?</div>
                                        <div class="small text-gray-500">Jae Chun Â· 1d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                            alt="...">
                                        <div class="status-indicator bg-warning"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Last month's report looks great, I am very happy with
                                            the progress so far, keep up the good work!</div>
                                        <div class="small text-gray-500">Morgan Alvarez Â· 2d</div>
                                    </div>
                                </a>
                                <a class="dropdown-item d-flex align-items-center" href="#">
                                    <div class="dropdown-list-image mr-3">
                                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                            alt="...">
                                        <div class="status-indicator bg-success"></div>
                                    </div>
                                    <div>
                                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                            told me that people say this to all dogs, even if they aren't good...</div>
                                        <div class="small text-gray-500">Chicken the Dog Â· 2w</div>
                                    </div>
                                </a>
                                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                            </div>
                        </li>

                        <div class="topbar-divider d-none d-sm-block"></div>-->

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=request.getSession().getAttribute("EmailLog")%></span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="loginData.jsp">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
<!--                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>-->
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="login.jsp" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->

                    <div class="d-sm-flex align-items-center justify-content-between mb-4"> 
                        <h1 class="h3 mb-0 text-gray-800">Système de gestion de la CA AutoFuture</h1>
                    </div>
               