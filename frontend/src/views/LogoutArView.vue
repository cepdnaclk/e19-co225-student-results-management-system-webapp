<template>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#"><font-awesome-icon icon="fa-solid fa-user-graduate" style="margin-right: 7px;"/>Academetrix</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav ms-auto">
                    <li><a class="nav-item nav-link" href="/home_ar">Home</a></li>
                    <li><a class="nav-item nav-link" href="/user_ar">View Users</a></li>
                    <li><a class="nav-item nav-link" href="/adduser_ar">User Registration</a></li>
                    <li><a class="nav-item nav-link current" href="#">Log Out</a></li>
                </ul>
            </div>
        </div>
    </nav>  
    
    <img class="bg" src="@/assets/bg.png" alt="">
    <div id="logout-confirmation" class="hidden">
        <div class="confirmation-box">
            <h3>Are you sure you want to log out?</h3>
            <a id="logout-yes" class="btn btn-warning" href="#">Yes, log out</a>
            <a id="logout-no" class="btn btn-warning" href="#">Cancel</a>
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
    width: 80%;
    font-size: 30px;
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

#logout-confirmation {
  /* Styles for the logout confirmation box overlay */
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
}

.confirmation-box {
  /* Styles for the logout confirmation box */
  background-color: white;
  padding: 20px;
  border-radius: 5px;
  text-align: center; /* Align the buttons to the center */
}

.confirmation-box .btn {
  /* Styles for the buttons */
  margin: 10px;
  width: 40%;
  font-size: 17px;
}

.hidden {
  /* Style to hide the logout confirmation box by default */
  display: none;
}

@media screen and (max-width: 768px){
    .confirmation-box .btn {
        font-size: 14px;
    }

    .confirmation-box h3 {
        font-size: 18px;
    }
}
</style>