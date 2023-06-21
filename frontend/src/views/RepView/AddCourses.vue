<template>
    <div class = "rep-addcourse">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <form class = "form">

                <div class="row mt-4">
                    <label for="coursename" class="col-sm-2 col-form-label">Course Name</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="coursename" placeholder="Course Name">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="coursecode" class="col-sm-2 col-form-label">Course Code</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="coursecourse" placeholder="Course Name">
                    </div>
                </div>

                <div class="col-lg-12 text-center">
                    <a class="btn btn-warning mt-2 mb-4" href="#" role="button">Create Course</a>
                </div>

            </form>

        </div>   

    </div>
</template>

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