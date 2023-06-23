<template>
    <div class="rep-viewcourses">
        <img class="bg" src="@/assets/bg.png" alt="">

        <div class="text-center">
            <a class="btn btn-warning col-lg-4 add" href="#"><!-- + Add New Course --></a>
            <a class="btn btn-warning col-lg-4 view" href="#"><!-- View Offered Courses --></a>
        </div>

        <!-- subject cards -->
        <div class="container">
            <h4>All courses available in the [dept name] department</h4>
            
            <!-- row-cols-md-3 is used to control how many card in a row -->
            <div class="row row-cols-4 row-cols-md-1 g-4">
                <div class="col">
                    <div class="card">

                        <!-- <h5 class="card-title">CO224</h5>
                        <p class="card-text">Computer Architecture</p> -->

                        <div class="card-body">

                            <h5 class="card-title">Lab </h5>
                            <h6 class="card-text">Allocated % - [] %</h6>
                        
                        </div>

                        <!-- Assignments component body -->
                        <div class="card-body">

                            <h5 class="card-title">Assignments</h5>
                            <p class="card-text">Software Construction</p>

                        </div>

                        <div class="card-body">

                            <h5 class="card-title">Assignments</h5>
                            <p class="card-text">Software Construction</p>

                        </div>

                        <div class="card-body">

                            <h5 class="card-title">Assignments</h5>
                            <p class="card-text">Software Construction</p>

                        </div>

                        <div class="card-body">

                            <form>

                                <label for="activity_name" class="col-sm-1 col-form-label">Activity Name</label>
                                    <div class="col-sm">
                                        <input type="text" class="form-control" id="activity_name" placeholder="Enter name">
                                    </div>

                                <label for="allocated_percentage" class="col-sm-2 col-form-label">Allocated %</label>
                                    <div class="col-sm">
                                        <input type="text" class="form-control" id="allocated_percentage" placeholder="xx%">
                                    </div>
                            </form>

                        </div>

                        <div class="card-body">

                            <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-add-item" href="#">+ Add item</button>
                            </div>

                        </div>


                    
                    </div>

                </div>
                <!-- End exam section  -->
                <div class="col">
                    <div class="card">
                        
                        <div class="card-body">
                            <h5 class="card-title">End Exam</h5>
                            <div class = "row">
                                <p class="card-text">End Exam results are not released yet</p>

                                <div class="col-sm-4">
                                    <button class="btn btn-sm-3 btn-request" href="#">Request Results</button>
                                </div>


                            </div>
                            
                        </div>
                    </div>
                </div>  
                
                <div class="col">
                    <div class="card">
                    
                        <div class="card-body">
                            <h5 class="card-title">End Exam</h5>
                            <div class = "row-result">
                                <p class="card-text">End Exam results are released </p>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<style scoped>
.body {
    padding-top: 100px;
}


.card-body{
    background-color: #f2f2f2;
    padding: 5px;
    margin-bottom: 10px;

    /* border-radius:10%; */
}

.card{
    background-color: #f06e6e;
    padding: 10px;
    /* border-radius:10%; */
}

.btn {
    font-size: 20px;
    font-weight: 400;
    padding: 15px 30px;
}

.add, .view {
    margin-top: 120px;
    margin-bottom: 100px;
    margin-right: 25px;
    padding: 5px;
    font-size: 25px;
    font-weight: 100px;
}

.btn-view, .btn-edit, .btn-delete {
    margin-top: 10px;
    margin-bottom: 5px;
    margin-right: 5px;
    padding: 5px;
    font-size: 20px;
    font-weight: 100px;
    background-color: #f2f2f2;
    width:100%;
} 

.btn-request{

    background-color: #f06e6e;

}

.btn-add-item {

    border-color: black;
    
}

/* .view {
    margin-top: 120px;
    margin-bottom: 100px;
    margin-left: 25px;
    padding: 5px;
} */


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