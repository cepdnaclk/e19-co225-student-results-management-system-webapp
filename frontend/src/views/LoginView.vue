<template>
    <div class="login">
        <img class="bg" src="@/assets/loginback.jpg" alt="">
        <div class="container col-lg-4 col-md-5">
            <h3 class="mb-5">Welcome to Academetix</h3>
            <p class="mb-md-5">Enter your User ID and Password to Log in to the system</p>
            <div class="form-floating mb-3">
                <input type="email" class="form-control" id="floatingID" placeholder="E/XX/XXX">
                <label for="floatingID">User ID</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>
            <button class="btn btn-primary">LOGIN</button>
            <a href="">Forgot Password?</a>
        </div>
        <div class="copyright">
            ©Academetix 2023
        </div>
    </div>
</template>

<script setup></script>

<style>
.login {
    height: 100vh;
    display: flex;
    align-items: center;
    text-align: center;
}

.login .bg {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: -1;
    opacity: 0.2;
}

.login .container {
    padding: 4rem 2rem 2rem;
    border-radius: 1.5rem;
    background: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.217);
}

.login .container h3 {
    font-weight: 300;
}

.login .container p {
    font-size: 0.9rem;
    font-weight: 500;
}

.login .container button {
    margin-top: 4rem;
    width: 80%;
    border-radius: 2rem;
    font-size: 1rem;
    font-weight: 600;
    padding: 0.6em 1em;
}

.login .copyright {
    position: absolute;
    bottom: 1rem;
    left: 50%;
    transform: translateX(-50%);
    font-size: 0.8rem;
    font-weight: 500;
}

.login .container a {
    font-size: 0.9rem;
    display: block;
    font-weight: 500;
    margin-top: 1rem;
}

@media screen and (max-width: 769px) {
    .login {
        align-items: flex-start;
    }

    .login .container {
        margin-top: 5rem;
        padding: 2rem;
    }

    .login .container {
        background: none;
        box-shadow: none;
    }

    .login .bg {
        opacity: 0.05;
    }

    .login .container button {
        width: 100%;
    }
}
</style>