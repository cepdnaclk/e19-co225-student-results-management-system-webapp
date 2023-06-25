<template>
    <div class="rep-addcourse">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <form class="form" @submit="submitHandle">


                <div class="row mt-4">
                    <label for="coursecode" class="col-sm-2 col-form-label">Course Code</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="coursecourse" placeholder="Course Name"
                            v-model="course.code" disabled>
                        <p v-if="validate.code.$error">{{ validate.code.$errors[0].$message }}</p>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="coursename" class="col-sm-2 col-form-label">Course Name</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="coursename" placeholder="Course Name"
                            v-model="course.name">
                        <p v-if="validate.name.$error">{{ validate.name.$errors[0].$message }}</p>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="coursecredit" class="col-sm-2 col-form-label">Course Credits</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="coursecredit" placeholder="Course Credits"
                            v-model="course.credits">
                        <p v-if="validate.credits.$error">{{ validate.credits.$errors[0].$message }}</p>
                    </div>
                </div>

                <div class="col-lg-12 text-center mt-3">
                    <button class="btn btn-warning mt-2 mb-4">Save Changes</button>
                </div>

            </form>

        </div>

    </div>
</template>

<script setup>
import axios from 'axios';
import { useVuelidate } from '@vuelidate/core'
import { required, maxValue, maxLength, helpers } from '@vuelidate/validators'
import { onMounted, reactive } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useStore } from 'vuex';

const router = useRouter()
const store = useStore()
const route = useRoute()

onMounted(() => {
    if (!route.params.code)
        router.push("/rep/viewcourses")

    axios
        .get("/course/", {
            params: {
                courseCode: route.params.code
            }
        })
        .then((res) => {
            course.name = res.data.name
            course.code = res.data.code
            course.credits = res.data.credits
        })
        .catch((err) => {
            console.log(err)
        })
})


const course = reactive({
    name: '',
    code: '',
    credits: '',
})
const rules = reactive({
    name: { required },
    code: { required, maxLength: helpers.withMessage("Enter Valid course Code", maxLength(5)) },
    credits: { required, maxValue: helpers.withMessage("Enter a valid credit score", maxValue(4)) },
})

const validate = useVuelidate(rules, course)

const updateCourse = async () => {
    try {
        const res = await axios.put("/course/", course)
        return res.data
    }
    catch (err) {
        console.log(err)
    }
}

const submitHandle = async (e) => {
    e.preventDefault()
    const pass = await validate.value.$validate()
    if (!pass) {
        return
    }
    const res = await updateCourse()
    store.commit("addSuccess", res)
    setTimeout(() => {
        store.commit("removeSuccess")
        router.push("/rep/viewcourses")
    }, 1000)
}
</script>

<style scoped>
.form {
    padding-top: 100px;
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

.btn {
    font-weight: 500;
}

/* @media screen and (max-width: 1200px) {
    .col-form-label {
        width: 20%;
        font-size: 15px;
    }
    .form-control {
        margin-left: 30px;
        width: 94%;
    }
    .form-select {
        margin-left: 30px; 
        width: 100%;
    }
    .form-check {
        margin-left: 30px;
    }
} */

input+p {
    font-size: 0.8rem;
    color: red;
    margin: 5px;
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

