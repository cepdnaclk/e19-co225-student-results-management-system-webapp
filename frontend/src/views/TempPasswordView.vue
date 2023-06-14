<template>
    <div class="temp">
        <img class="bg" src="@/assets/loginback.jpg" alt="">
        <div class="container col-lg-4 col-md-5">
            <h3 class="mb-5">Forget Your Password?</h3>
            <p class="mb-md-5">Don't worry, we have sent a temporary password to your email. Enter the temporary password below</p>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingTempPassword" placeholder="Password">
                <label for="floatingTempPassword">Temporary Password</label>
            </div>
            <button class="btn btn-primary">Proceed</button>
        </div>
        <div class="copyright">
            ©Academetrix 2023
        </div>
    </div>
</template>

<script setup></script>

<style>
.temp {
    height: 100vh;
    display: flex;
    align-items: center;
    text-align: center;
}

.temp .bg {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: -1;
    opacity: 0.2;
}

.temp .container {
    padding: 4rem 2rem;
    border-radius: 1.5rem;
    background: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.217);
}

.temp .container h3 {
    font-weight: 300;
}

.temp .container p {
    font-size: 0.9rem;
    font-weight: 500;
}

.temp .container button {
    margin-top: 2rem;
    width: 80%;
    border-radius: 2rem;
    font-size: 1rem;
    font-weight: 600;
    padding: 0.6em 1em;
}

.temp .copyright {
    position: absolute;
    bottom: 1rem;
    left: 50%;
    transform: translateX(-50%);
    font-size: 0.8rem;
    font-weight: 500;
}

@media screen and (max-width: 769px) {
    .temp {
        align-items: flex-start;
    }

    .temp .container {
        margin-top: 5rem;
        padding: 2rem;
    }

    .temp .container {
        background: none;
        box-shadow: none;
    }

    .temp .bg {
        opacity: 0.05;
    }

    .temp .container button {
        width: 100%;
    }
}
</style>