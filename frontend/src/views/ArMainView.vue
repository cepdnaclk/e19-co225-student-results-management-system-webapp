<template>
    <div class="ar-main">
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
                        <li><router-link class="nav-item nav-link" to="/ar/home">Home</router-link></li>
                        <li><router-link class="nav-item nav-link" to="/ar/user">View Users</router-link></li>
                        <li><router-link class="nav-item nav-link" to="/ar/adduser">User Registration</router-link></li>
                        <li><router-link class="nav-item nav-link" to="/ar/logout">Log Out</router-link></li>
                    </ul>
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

<script>
export default {

}
</script>

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