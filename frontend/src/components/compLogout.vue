<template>
    <div class="logout">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div id="logout-confirmation">
            <div class="backdrop" @click="hideLogout"></div>
            <div class="confirmation-box">
                <h4>Are you sure you want to log out?</h4>
                <button @click="logout" class="btn btn-warning">Yes, log out</button>
                <button @click="hideLogout" class="btn btn-warning">Cancel</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useStore } from 'vuex';
import axios from 'axios';
import { useRouter } from 'vue-router';

const store = useStore()
const router = useRouter()

const hideLogout = () => {
    store.state.showLogout = false
}

const logout = () => {
    axios.post("/logout")
        .then(res => {
            console.log(res)
            hideLogout()
            router.push("/login")
        })
        .catch(err => {
            console.log(err)
        })
}
</script>

<style scoped>
.logout {
    position: relative;
    z-index: 1000000000000;
}

.logout .backdrop {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100vh;
    background: rgba(0, 0, 0, 0.196);
    z-index: -1;
}

.btn {
    width: 80%;
    font-size: 30px;
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
    text-align: center;
    /* Align the buttons to the center */
}

.confirmation-box .btn {
    /* Styles for the buttons */
    margin: 10px;
    width: 40%;
    font-size: 17px;
}


@media screen and (max-width: 768px) {
    .confirmation-box .btn {
        font-size: 14px;
    }

    .confirmation-box h3 {
        font-size: 18px;
    }
}
</style>