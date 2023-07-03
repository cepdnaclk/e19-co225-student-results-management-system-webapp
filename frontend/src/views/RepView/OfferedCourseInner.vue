<template>
    <div class="rep-courseofferinner">
        <img class="bg" src="@/assets/bg.png" alt="">
        <!-- subject cards -->
        <div class="container">
            <h4>All courses available in the [dept name] department</h4>

            <!-- row-cols-md-3 is used to control how many card in a row -->
            <div class="row row-cols-4 row-cols-md-1 g-4">
                <div class="col">
                    <div class="card">

                        <!-- Activity complete look -->
                        <div class="card-body">

                            <div class="row">

                                <div class="col-3">
                                    <h5 class="card-title">Lab</h5>
                                </div>
                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Edit</button>
                                </div>
                                <div class="col-3">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Delete</button>
                                </div>
                                <div class="col-2">
                                    <h5 class="card-text text-end">Allocated % : 30%</h5>
                                </div>
                            </div>

                            <hr class="horizontal-line">

                            <div class="row">
                                <div class="col-5">

                                    <h5>Lab 1 : Name </h5>
                                </div>

                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Edit</button>
                                </div>

                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Delete</button>
                                </div>

                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-activity-title" href="#">Request Results</button>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-5">

                                    <h5>Lab 2 : Name </h5>

                                </div>

                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Edit</button>
                                </div>

                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Delete</button>
                                </div>

                                <div class="col-2">
                                    <div class="card-body cb-left">
                                        <h5 class="text-end">Results uploaded</h5>
                                    </div>
                                </div>


                            </div>

                            <div class="row">
                                <div class="col-sm-4">
                                    <button class="btn btn-sm-3 btn-add-item" href="#">+ Add item</button>
                                </div>
                            </div>

                        </div>

                        <!-- adding activity into assessments -->

                        <div class="card-body">

                            <div class="row">

                                <div class="col-3">
                                    <h5 class="card-title">Assignments</h5>
                                </div>

                                <div class="col-7">
                                    <h5 class="card-text text-end">Allocated % : xx%</h5>
                                </div>

                            </div>

                            <hr class="horizontal-line">

                            <form class="row">

                                <label for="activity_name" class="col-sm-2 col-form-label text-field">Activity Name</label>
                                <div class="col-3">
                                    <input type="text" class="form-control" id="activity_name" placeholder="Enter name">
                                </div>

                                <label for="max_marks" class="col-sm-2 col-form-label text-field">Max Marks</label>
                                <div class="col-2">
                                    <input type="text" class="form-control" id="max_marks" placeholder="Max Marks">
                                </div>

                                <div class="col-1">
                                    <button class="btn btn-sm-3 btn-save-item" href="#">Save item</button>
                                </div>

                            </form>

                        </div>

                        <!-- after adding main items (labs, Assignments) not added sub items (lab1, lab2) -->

                        <div class="card-body">

                            <div class="row">

                                <div class="col-3">
                                    <h5 class="card-title">Assignments</h5>
                                </div>
                                <div class="col-2">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Edit</button>
                                </div>
                                <div class="col-3">
                                    <button class="btn btn-sm-3 btn-assessment-title" href="#">Delete</button>
                                </div>
                                <div class="col-2">
                                    <h5 class="card-text text-end">Allocated % : xx%</h5>
                                </div>
                            </div>

                            <hr class="horizontal-line">

                            <div class="row">
                                <div class="col-sm-4">
                                    <button class="btn btn-sm-3 btn-add-item" href="#">+ Add item</button>
                                </div>
                            </div>
                        </div>

                        <!-- after clicking add item button -->

                        <div class="card-body">

                            <form class="row">

                                <label for="assessment_name" class="col-sm-2 col-form-label text-field">Activity
                                    Name</label>
                                <div class="col-sm">
                                    <input type="text" class="form-control" id="assessment_name" placeholder="Enter name">
                                </div>

                                <label for="allocated_percentage" class="col-sm-2 col-form-label text-field">Allocated
                                    %</label>
                                <div class="col-sm">
                                    <input type="text" class="form-control" id="allocated_percentage" placeholder="xx%">
                                </div>
                            </form>

                            <hr class="horizontal-line">

                            <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-add-item" href="#">Save item</button>
                            </div>

                        </div>

                        <!-- add item (main) button -->

                        <div class="card-body">

                            <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-add-item" href="#">+ Add item</button>
                            </div>

                        </div>

                    </div>

                </div>
                <!-- End exam section - before results -->
                <div class="col">
                    <div class="card">

                        <div class="card-body">
                            <h5 class="card-title">End Exam</h5>
                            <div class="row">

                                <div class="col-9">

                                    <p class="card-text">End Exam results are not released yet</p>
                                </div>

                                <div class="col-3">
                                    <button class="btn btn-sm-3 btn-activity-title" href="#">Request Results</button>
                                </div>


                            </div>

                        </div>
                    </div>
                </div>

                <!-- End exam section - after results -->
                <div class="col">
                    <div class="card">

                        <div class="card-body">
                            <div class="row">

                                <h5 class="card-title">End Exam</h5>
                                <div class="col-9">
                                    <p class="card-text">End Exam results are released </p>
                                </div>

                                <div class="col-2">
                                    <div class="card-body cb-left">
                                        <h5 class="text-end">Results uploaded</h5>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</template>

<style scoped>
.rep-courseofferinner {
    padding-top: 7rem;
}

.row {

    padding: 5px;
}

.card-body {
    background-color: #f2f2f2;
    padding: 5px;
    margin-bottom: 10px;

    /* border-radius:10%; */
}

.card {
    background-color: #f06e6e;
    padding: 10px;
    /* border-radius:10%; */
}

.cb-left {
    border-color: black;
    border-radius: 5px;
    background-color: green;
    height: 35px;
    width: 250px;
    display: flex;
    align-items: center;
    justify-content: center;

}

.btn {
    font-size: 20px;
    font-weight: 400;
    padding: 15px 30px;
}

.add,
.view {
    margin-top: 120px;
    margin-bottom: 100px;
    margin-right: 25px;
    padding: 5px;
    font-size: 25px;
    font-weight: 100px;
}

.btn-request {

    background-color: #f06e6e;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;

}

.btn-add-item {

    border-color: black;
    height: 20px;
    width: 250px;
    display: flex;
    align-items: center;
    justify-content: center;


}

.btn-save-item {
    padding: 5px;
    border-color: black;
    height: 40px;
    width: 250px;
    align-items: center;
    justify-content: center;
}

.btn-assessment-title {

    border-color: black;
    height: 20px;
    width: 150px;
    display: flex;
    align-items: center;
    justify-content: center;
}

.btn-activity-title {
    border-color: black;
    height: 20px;
    width: 250px;
    display: flex;
    align-items: center;
    justify-content: center;
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

.row-result {
    background-color: aquamarine;
    width: 50%S;
}

.text-field {

    font-size: 20px;
    font-weight: 450;
}

@media screen and (max-width: 769px) {
    .btn {
        font-size: 30px;
        padding: 15px 40px;
    }
}

/* footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
} */
</style>