<template>
    <div class = "rep-addcourse">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">

            <p> Enter the following details to offer this course </p>

            <form class = "form">

                <div class="row mt-4">
                    <label for="credits" class="col-sm-2 col-form-label">Number of Credits</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="credits" placeholder="Number of Credits">
                    </div>

                    <label for="year" class="col-sm-2 col-form-label">Year</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="year" placeholder="20xx">
                    </div>
                </div>

                <dropdown>
                    <div class="row mt-4">
                        <label for="batch" class="col-sm-2 col-form-label">Batch</label>
                        <div class="col-sm">
                            <select class="form-select" aria-label="Default select example">
                            <option selected>Select Batch</option>
                            <option value="1">E17</option>
                            <option value="2">E18</option>
                            <option value="3">E19</option>
                            <option value="4">E20</option>
                            <option value="5">E21</option>
                            </select>
                        </div>

                        <label for="semester" class="col-sm-2 col-form-label">Semester</label>
                        <div class="col-sm">
                            <select class="form-select" aria-label="Default select example">
                            <option selected>Select Batch</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            </select>
                        </div>

                    </div>
                </dropdown>

                <div class="row mt-4">
                    <label for="coor_name" class="col-sm-2 col-form-label">Course Coordinator Name</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="course_coor_name" placeholder="Prof/Dr/Mr/Ms _ Last Name _ Initials">
                    </div>
                </div>

                <div class="row mt-4">
                    <label for="coor_email" class="col-sm-2 col-form-label">Course Coordinator Email</label>
                    <div class="col-sm">
                        <input type="text" class="form-control" id="course_coor_email" placeholder="@eng.pdn.ac.lk">
                    </div>
                </div>

                <div class="col-lg-12 text-center">
                    <a class="btn btn-warning mt-2 mb-4" href="#" role="button">Save Changes</a>
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

.p {
    color: rgb(3, 0, 0);
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