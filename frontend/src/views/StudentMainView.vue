<template>
    <div class="student-main">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#"><font-awesome-icon icon="fa-solid fa-user-graduate"
                        style="margin-right: 7px;" />Academetrix</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item nav-link" to="/student/home">Home</li>
                        <li class="nav-item nav-link" to="/student/dashboard">Dashboard</li>
                        <li class="nav-item nav-link" to="/student/courses">Courses</li>
                    </ul>
                    <i class="bi bi-person-circle fa-xl"></i>

                    <div class="sub-menu-wrap">
                        <div class="sub-menu">
                            <div class="user-info">
                                <i class="bi bi-person-circle fa-3x"></i>
                                <h5>User ID</h5>
                            </div>
                            <hr>
                            <a href="#" class="sub-menu-link">
                                <font-awesome-icon icon="fa-solid fa-user" class="pic" />
                                <h6>Edit profile</h6>
                                <span>></span>
                            </a>
                            <a href="#" class="sub-menu-link">
                                
                                <font-awesome-icon icon="fa-solid fa-right-from-bracket" class="pic" />
                                <h6>Log out</h6>
                                <span>></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <router-view />
        <footer class="fixed-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <ul class="list-inline text-center">
                            <li class="list-inline-item">©Academetrix 2023</li>
                            <li class="list-inline-item"><router-link to="#">License</router-link></li>
                            <li class="list-inline-item"><router-link to="#">Terms</router-link></li>
                            <li class="list-inline-item"><router-link to="#">Privacy</router-link></li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</template>

<script></script>

<style scoped>
.navbar {
    background: #2c3e50;
    height: 75px;
}

.navbar-brand {
    color: white;
    font-weight: 600;
}

.nav-item:hover {
    font-weight: 400;
}

.navbar a.router-link-active.router-link-exact-active {
    color: white;
    font-weight: 500;
}

.fa-xl {
    margin-left: 10px;
    color: #ffffff8c;
}

.fa-3x {
    align-items: center;
    margin-right: 15px;
}

.sub-menu-wrap {
    position: absolute;
    top: 95%;
    right: 7%;
    width: 230px;
}

.sub-menu {
    background: white;
    padding: 20px;
    margin: 10px;
}

.user-info {
    display: flex;
    align-items: center;
}

.user-info h5 {
    font-weight: 500;
    margin-left: 5px;
}

hr {
    margin-top: 5px;
}

.sub-menu-link {
    display: flex;
    align-items: center;
    text-decoration: none;
    /* color: #525252; */
    color: black;
    margin: 12px 0 ;
}

.sub-menu-link h6 {
    font-weight: 300;
    width: 100%;
    margin-top: 15px;
}

.sub-menu-link .pic {
    width: 30px;
    background: #e5e5e5;
    border-radius: 50%;
    padding: 8px;
    margin-right: 15px;
}

.sub-menu-link span {
    font-weight: 300;
    font-size: 20px;
    transition: transform 0.5s;
}

.sub-menu-link:hover span {
    transform: translate(5px);
}

.sub-menu-link:hover h6 {
    font-weight: 500;
}

footer {
    background-color: #2c3e50;
    padding: 0;
    text-align: center;
    font-size: 14px;
    justify-content: center;
    align-items: center;
}

.list-inline-item {
    text-align: center;
    padding: 20px 5px;
    margin: 10px;
    color: white;
}

.list-inline li {
    display: inline-block;
    margin-right: 10px;
}

.list-inline li a {
    text-decoration: none;
    color: rgba(255, 255, 255, 0.5);
    font-weight: 400;
}

.list-inline li a:hover {
    color: white;
}
</style>