<template>
    <div class="coor-log">
        <Logout :show-additional-item="true"></Logout>
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container body">
            <h5 class="mb-4">You have been invited to upload the following results of [course_code-year-course_name]</h5>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Result item
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                        Lab 1: HTML Web Page Designing
                        <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Assignment 2: ER Diagrams
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Enter your targeted GPA for semester 4
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Result item
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                        Lab 1: HTML Web Page Designing
                        <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Assignment 2: ER Diagrams
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-2">
                <div class="col-lg-9">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            Enter your targeted GPA for semester 4
                            <a class="btn btn-light" href="#" role="button">Upload</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 text-center">
                <a class="btn btn-warning mt-4 mb-5" href="#" role="button">Submit</a>
            </div>
        </div>
    </div>
</template>

<script>
import Logout from '../CoorMainView.vue';

export default {
  components: {
    Logout
  }
}
</script>

<style>
.body {
    padding-top: 50px;
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

.btn-light {
    background: rgb(234, 234, 234);
}

.btn-warning {
    font-size: 18px;
    width: 10%;
}

@media screen and (max-width: 992px) {
    .btn {
        width: 22%;
        font-size: 17px;
    }
    .card{
        font-size: 15px
    }
    
    h5 {
        font-size: 15px;
    }
}

@media screen and (max-width: 768px) {
    .btn {
        width: 30%;
        font-size: 15px;
    }
    h5 {
        font-size: 17px;
    }
}
</style>