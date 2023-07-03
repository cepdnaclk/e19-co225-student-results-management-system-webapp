<template>
    <div class="coor-no-log">
        <img class="bg" src="@/assets/bg.png" alt="">
        <form class="container body" @submit.prevent="submit">
            <h5 class="mb-4">You have been invited to upload the following results of [course_code-year-course_name]</h5>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <div>
                                <span>{{ assessment.type }}</span><br>
                                {{ assessment.name }}
                            </div>
                            <input type="file" name="" @change="fileUpload" id="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 offset-lg-3 text-center">
                <button class="btn btn-warning mt-4 mb-5" role="button">Submit</button>
            </div>
        </form>
    </div>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";
import { useRoute } from "vue-router";

const route = useRoute()
const assessment = ref({})
const file = ref()
console.log(route.params.id)
axios
    .get("/assesment/", {
        params: {
            id: route.params.id
        }
    })
    .then((res) => {
        assessment.value = res.data
    })
    .catch((err) => {
        console.log(err)
    })

const fileUpload = (e) => {
    file.value = e.target.files[0]
}

const submit = () => {
    const formData = new FormData();
    formData.append('file', file);

    axios.post('/upload', formData)
        .then(response => {
            // Handle success
            console.log(response.data);
        })
        .catch(error => {
            // Handle error
            console.error(error);
        });
}
</script>

<style scoped>
.body {
    padding-top: 50px;
    min-height: 90vh;
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

h5 {
    text-align: center;
    font-weight: 500;
}

.card {
    text-align: left;
    font-size: 18px;
    font-weight: 400;
}

.card span {
    font-size: 0.8rem;
    font-weight: bold;
}

.card input {
    font-size: 0.8rem;
}

.btn-light {
    background: rgb(234, 234, 234);
}

.btn-warning {
    font-size: 18px;
}

@media screen and (max-width: 992px) {
    .btn {

        font-size: 17px;
    }

    .card {
        font-size: 15px
    }

    h5 {
        font-size: 15px;
    }
}

@media screen and (max-width: 768px) {
    .btn {

        font-size: 15px;
    }

    h5 {
        font-size: 17px;
    }
}
</style>