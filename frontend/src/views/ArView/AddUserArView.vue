<template>
    <div class="ar-adduser">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <form class="form">
                <!-- dropdown -->
                <!-- <div class="row">
                <label for="acc_type" class="col-sm-2 col-form-label">Account type</label>
                <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example">
                    <option selected>Account type</option>
                    <option value="1">Student</option>
                    <option value="2">Representative</option>
                    <option value="3">Coordinator</option>
                    </select>
                </div>
            </div> -->
                <div class="row mt-4">
                    <label for="acc_type" class="col-sm-2 col-form-label other">Account type</label>
                    <div class="col-sm-9">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" id="option1" value="1">
                            <label class="form-check-label" for="option1">Student</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" id="option2" value="2">
                            <label class="form-check-label" for="option2">Representative</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="acc_type" id="option3" value="3">
                            <label class="form-check-label" for="option3">Coordinator</label>
                        </div>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="fullname" class="col-sm-2 col-form-label">Full Name</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="fullname" placeholder="Full name">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="name" class="col-sm-2 col-form-label">Name with initials</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="name" placeholder="Name with initials">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="regno" class="col-sm-2 col-form-label">Regestration number</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="regno" placeholder="E/XX/XXX">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="batch" class="col-sm-2 col-form-label">Batch</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="batch" placeholder="Batch">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="dep" class="col-sm-2 col-form-label other">Department</label>
                    <div class="col-lg-10 col-sm-9">
                        <select class="form-select" aria-label="Default select example">
                            <option selected>Department</option>
                            <option value="1">Computer Engineering</option>
                            <option value="2">Electrical & Electronic Engineering</option>
                            <option value="3">Chemical & Process Engineering</option>
                            <option value="4">Mechanical Engineering</option>
                            <option value="5">Manufacturing & Industrial Engineering</option>
                            <option value="6">Civil Engineering</option>
                        </select>
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="uni_email" class="col-sm-2 col-form-label">University Email</label>
                    <div class="col-sm">
                        <input type="email" class="form-control" id="uni_email" placeholder="University email">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="personal_email" class="col-sm-2 col-form-label">Personal Email</label>
                    <div class="col-sm">
                        <input type="email" class="form-control" id="personal_email" placeholder="Personal email">
                    </div>
                </div>

                <div class="row mt-4 mb-3">
                    <label for="contact" class="col-sm-2 col-form-label">Contact number</label>
                    <div class="col-sm">
                        <input type="tel" class="form-control" id="contact" placeholder="Contact number">
                    </div>
                </div>


                <div class="col-lg-12 text-center">
                    <a class="btn btn-warning mt-2 mb-4" href="#" role="button">Create Account</a>
                </div>
            </form>
        </div>
    </div>
</template>

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