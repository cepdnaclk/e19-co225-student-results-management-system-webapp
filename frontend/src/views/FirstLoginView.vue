<template>
    <div class="firstlogin">
        <img class="bg" src="@/assets/loginback.jpg" alt="">
        <div class="container col-lg-4 col-md-5">
            <h3 class="mb-3">Hey Dinuka,</h3>
            <h4 class="mb-5">Welcome to Academetrix</h4>
            <p class="mb-md-5">To get you registered in to the system, first setup a password</p>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Enter Password</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingRePassword" placeholder="Password">
                <label for="floatingRePassword">Re-Enter Password</label>
            </div>
            <button class="btn btn-primary">Create Account</button>
        </div>
        <div class="copyright">
            ©Academetrix 2023
        </div>
    </div>
</template>

<script setup></script>

<style>
.firstlogin {
    height: 100vh;
    display: flex;
    align-items: center;
    text-align: center;
}

.firstlogin .bg {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: -1;
    opacity: 0.2;
}

.firstlogin .container {
    padding: 4rem 2rem;
    border-radius: 1.5rem;
    background: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.217);
}

.firstlogin .container h3 {
    font-weight: 300;
}

.firstlogin .container h4 {
    font-weight: 200;
}

.firstlogin .container p {
    font-size: 0.9rem;
    font-weight: 500;
}

.firstlogin .container button {
    margin-top: 2rem;
    width: 80%;
    border-radius: 2rem;
    font-size: 1rem;
    font-weight: 600;
    padding: 0.6em 1em;
}

.firstlogin .copyright {
    position: absolute;
    bottom: 1rem;
    left: 50%;
    transform: translateX(-50%);
    font-size: 0.8rem;
    font-weight: 500;
}

@media screen and (max-width: 769px) {
    .firstlogin {
        align-items: flex-start;
    }

    .firstlogin .container {
        margin-top: 5rem;
        padding: 2rem;
    }

    .firstlogin .container {
        background: none;
        box-shadow: none;
    }

    .firstlogin .bg {
        opacity: 0.05;
    }

    .firstlogin .container button {
        width: 100%;
    }
}
</style>