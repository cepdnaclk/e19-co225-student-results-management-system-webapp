<template>
    <div class="reset">
        <img class="bg" src="@/assets/loginback.jpg" alt="">
        <div class="container col-lg-4 col-md-5">
            <h3 class="mb-5">Reset Password</h3>
            <p class="mb-md-5">Enter a new password</p>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Enter Password</label>
            </div>
            <div class="form-floating">
                <input type="password" class="form-control" id="floatingRePassword" placeholder="Password">
                <label for="floatingRePassword">Re-Enter Password</label>
            </div>
            <button class="btn btn-primary">Reset Password</button>
        </div>
        <div class="copyright">
            ©Academetix 2023
        </div>
    </div>
</template>

<script setup></script>

<style>
.reset {
    height: 100vh;
    display: flex;
    align-items: center;
    text-align: center;
}

.reset .bg {
    position: absolute;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    z-index: -1;
    opacity: 0.2;
}

.reset .container {
    padding: 4rem 2rem;
    border-radius: 1.5rem;
    background: white;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.217);
}

.reset .container h3 {
    font-weight: 300;
}

.reset .container p {
    font-size: 0.9rem;
    font-weight: 500;
}

.reset .container button {
    margin-top: 2rem;
    width: 80%;
    border-radius: 2rem;
    font-size: 1rem;
    font-weight: 600;
    padding: 0.6em 1em;
}

.reset .copyright {
    position: absolute;
    bottom: 1rem;
    left: 50%;
    transform: translateX(-50%);
    font-size: 0.8rem;
    font-weight: 500;
}

@media screen and (max-width: 769px) {
    .reset {
        align-items: flex-start;
    }

    .reset .container {
        margin-top: 5rem;
        padding: 2rem;
    }

    .reset .container {
        background: none;
        box-shadow: none;
    }

    .reset .bg {
        opacity: 0.05;
    }

    .reset .container button {
        width: 100%;
    }
}
</style>