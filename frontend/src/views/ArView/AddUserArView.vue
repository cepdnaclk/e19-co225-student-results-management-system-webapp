<template>
    <div class="ar-adduser">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <form class="form" @submit.prevent="addUser">
                <div class="row mt-4">
                    <label for="acc_type" class="col-sm-2 col-form-label other">Account type</label>
                    <div class="col-lg-10 col-sm-11">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" v-model="user.role" id="option1"
                                value="student">
                            <label class="form-check-label" for="option1">Student</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" v-model="user.role" id="option2"
                                value="representative">
                            <label class="form-check-label" for="option2">Representative</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" v-model="user.role" id="option3"
                                value="coordinator">
                            <label class="form-check-label" for="option3">Coordinator</label>
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="fullname" class="col-sm-2 col-form-label">Honorofic</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="fullname" v-model="user.honorific" placeholder="Mr.">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="lname" class="col-sm-2 col-form-label">initials</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="lname" v-model="user.initials" placeholder="initials">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="name" class="col-sm-2 col-form-label">Lastname</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="name" v-model="user.lastName" placeholder="lastname">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="regno" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="regno" v-model="user.userName"
                            placeholder="E/XX/XXX or adminXX">
                    </div>
                    <p class="errmsg" v-if="validate.userName.$error">{{ validate.userName.$errors[0].$message }}</p>
                </div>

                <div class="row mt-4">
                    <label for="pass" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm">
                        <input type="password" class="form-control" v-model="user.password" id="pass">
                    </div>
                    <p class="errmsg" v-if="validate.password.$error">{{ validate.password.$errors[0].$message }}</p>
                </div>

                <div class="row mt-4">
                    <label for="dep" class="col-sm-2 col-form-label other">Department</label>
                    <div class="col-lg-10 col-sm-11">
                        <select class="form-select" aria-label="Default select example" v-model="user.deptId">
                            <option selected>Department</option>
                            <option value="CO">Computer Engineering</option>
                            <option value="EE">Electrical & Electronic Engineering</option>
                            <option value="EM">Engineering Mathematics</option>
                            <option value="CP">Chemical & Process Engineering</option>
                            <option value="ME">Mechanical Engineering</option>
                            <option value="PR">Manufacturing & Industrial Engineering</option>
                            <option value="CE">Civil Engineering</option>
                        </select>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="uni_email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm">
                        <input type="email" class="form-control" id="uni_email" v-model="user.email"
                            placeholder="University email">
                    </div>
                    <p class="errmsg" v-if="validate.email.$error">{{ validate.email.$errors[0].$message }}</p>
                </div>

                <div class="row mt-4 mb-3">
                    <label for="contact" class="col-sm-2 col-form-label">Contact number</label>
                    <div class="col-sm">
                        <input type="tel" class="form-control" id="contact" v-model="user.contact"
                            placeholder="Contact number">
                    </div>
                </div>


                <div class="col-lg-12 text-center">
                    <button class="btn btn-warning mt-2 mb-4" role="button">Create Account</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>
import { reactive } from "vue";
import { useVuelidate } from '@vuelidate/core'
import { required, email } from '@vuelidate/validators'
import axios from "axios";

const user = reactive({
    userName: "",
    password: "",
    honorific: "",
    initials: "",
    lastName: "",
    role: "student",
    deptId: "CO",
    email: "",
    contact: ""
})

const rules = {
    userName: { required },
    password: { required },
    honorific: {},
    initials: {},
    lastName: {},
    role: { required },
    deptId: { required },
    email: { email },
    contact: {}
}

const validate = useVuelidate(rules, user)

const addUser = async () => {
    const pass = await validate.value.$validate()
    if (!pass) {
        return
    }
    axios
        .post("/user/", user)
        .then(res => {
            console.log(res)
        })
        .catch(err => {
            console.log(err)
        })
}
</script>

<style scoped>
.form {
    padding-top: 80px;
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

.navbar .current {
    color: white;
    font-weight: 500;
}

.col-form-labe {
    margin-right: 20px;
}

.btn {
    font-weight: 500;
}

@media screen and (max-width: 1200px) {

    /* Styles for screens up to 1200px width */
    .col-form-label {
        font-size: 14px;
    }
}

@media screen and (max-width: 992px) {

    /* Styles for screens up to 992px width */
    .col-sm-2 {
        flex: 0 0 100%;
        max-width: 100%;
        text-align: left;
        margin-bottom: 0px;
    }

    .col-sm-9 {
        flex: 0 0 100%;
        max-width: 100%;
    }

    .form-check-inline {
        display: inline-block;
        margin-bottom: 0;
    }

    .btn {
        width: 22%;
        font-size: 17px;
    }

    .col-form-label {
        margin-top: 5px;
    }
}

@media screen and (max-width: 768px) {

    /* Styles for screens up to 768px width */
    .form-check-label {
        display: inline-block;
        margin-bottom: 0;
    }

    .col-sm {
        margin-bottom: 0px;
    }

    .btn {
        width: 30%;
        font-size: 15px;
    }
}

@media screen and (max-width: 576px) {

    /* Styles for screens up to 576px width */
    .form-check-inline {
        margin-right: 10px;
        margin-bottom: 0px;
    }
}
</style>