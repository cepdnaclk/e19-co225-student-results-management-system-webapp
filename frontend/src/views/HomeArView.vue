<template>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#"><font-awesome-icon icon="fa-solid fa-user-graduate" style="margin-right: 7px;"/>Academetrix</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav ms-auto">
                    <li><a class="nav-item nav-link current" href="#">Home</a></li>
                    <li><a class="nav-item nav-link" href="/user_ar">View Users</a></li>
                    <li><a class="nav-item nav-link" href="/adduser_ar">User Registration</a></li>
                    <li><a class="nav-item nav-link" href="/logout_ar">Log Out</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <img class="bg" src="@/assets/bg.png" alt="">
    <div class="container">
        <div class="col-md-12 text-center">
            <a class="btn btn-warning add" href="#">Add User</a>
        </div>
        <div class="col-md-12 text-center">
            <a class="btn btn-warning view" href="#">View User</a>
        </div>
    </div>

    <footer class="fixed-bottom">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <ul class="list-inline text-center">
                        <li class="list-inline-item">©Academetrix 2023</li>
                        <li class="list-inline-item"><a href="#">License</a></li>
                        <li class="list-inline-item"><a href="#">Terms</a></li>
                        <li class="list-inline-item"><a href="#">Privacy</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>

</template>

<style>

.body {
    padding-top: 100px;
}


.btn {
    width: 35%;
    font-size: 40px;
    font-weight: 400;
    padding-top: 15px;
    padding-bottom: 15px;
}

.add{
    margin-top: 200px;
    margin-bottom: 100px;
}

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

.navbar .current {
    color: white;
    font-weight: 500;
}

.bg {
    background-size: cover;
    position: fixed;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: -1;
    opacity: 0.1;
    background-attachment: fixed;
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

@media screen and (max-width: 769px) {
    .btn {
        width: 45%;
        font-size: 35px;
        font-weight: 400;
        padding-top: 15px;
        padding-bottom: 15px;
    }

    .add{
        margin-top: 200px;
        margin-bottom: 100px;
    }

}

</style>