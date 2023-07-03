<template>
    <div class="login">
        <img class="bg" src="@/assets/loginback.jpg" alt="">
        <form @submit="onLogin" class="container col-lg-4 col-md-5">
            <h3 class="mb-5">Welcome to Academetrix</h3>
            <p class="mb-md-5">Enter your User ID and Password to Log in to the system</p>
            <div class="form-floating">
                <input type="text" class="form-control" id="floatingID" placeholder="E/XX/XXX" v-model="user.username">
                <label for="floatingID">User ID</label>
            </div>
            <p class="errmsg" v-if="validate.username.$error">{{ validate.username.$errors[0].$message }}</p>
            <div class="form-floating mt-3">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                    v-model="user.password">
                <label for="floatingPassword">Password</label>
            </div>
            <p class="errmsg" v-if="validate.password.$error">{{ validate.password.$errors[0].$message }}</p>
            <button class="btn btn-primary">LOGIN</button>
            <a href="">Forgot Password?</a>
        </form>
        <div class="copyright">
            ©Academetrix 2023
        </div>
    </div>
</template>

<script setup>
import axios from 'axios';
import { useVuelidate } from '@vuelidate/core'
import { required } from '@vuelidate/validators'
import { reactive } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';

const store = useStore()
const router = useRouter()

const user = reactive({
    username: "",
    password: ""
})

const rules = {
    username: { required },
    password: { required }
}

const validate = useVuelidate(rules, user)

const onLogin = async (e) => {
    e.preventDefault()
    const pass = await validate.value.$validate()
    if (!pass) {
        return
    }

    const logUser = new FormData()
    logUser.append("username", user.username)
    logUser.append("password", user.password)

    try {
        const res = await axios.post("/login", logUser, {
            withCredentials: true,
        })
        store.state.username = res.data.username;
        store.state.role = res.data.authorities[0].authority;
        setTimeout(() => {
            if (store.state.role == 'Student')
                router.push("/student/dashboard")
            else if (store.state.role == 'admin')
                router.push("/ar/home")
        }, 500)
    }
    catch (err) {
        console.log(err)
    }
}
</script>

<style scoped>
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