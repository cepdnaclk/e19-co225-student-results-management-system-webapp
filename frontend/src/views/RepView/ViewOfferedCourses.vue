<template>
    <div class="ar-home">
        <img class="bg" src="@/assets/bg.png" alt="">

        <div class="text-center">
            <a class="btn btn-warning col-lg-4 add" href="#">+ Add New Course</a>
            <a class="btn btn-warning col-lg-4 view" href="#">View Courses</a>
        </div>

        <!-- subject cards -->
        <div class="container">
            <h4>Offered Courses In This Semester</h4>
            
            <!-- row-cols-md-3 is used to control how many card in a row -->
            <div class="row row-cols-4 row-cols-md-3 g-4">
                <div class="col">
                    <div class="card">

                        <!-- <h5 class="card-title">CO224</h5>
                        <p class="card-text">Computer Architecture</p> -->

                        <div class="card-body">

                            <h5 class="card-title">CO224 - 2023</h5>
                            <p class="card-text">Computer Architecture</p>

                            
                        </div>
                        <div class ="button-panel">

                            <div class="row">
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-view">View</button>
                                </div>
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-edit">Edit</button>
                                </div>
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-delete">Delete</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                    
                        <div class="card-body">
                            <h5 class="card-title">CO225 - 2023</h5>
                            <p class="card-text">Software Construction</p>
                        </div>
                        <div class ="button-panel">

                            <div class="row">
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-view">View</button>
                                </div>
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-edit">Edit</button>
                                </div>
                                <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-delete">Delete</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                    
                    <div class="card-body">
                        <h5 class="card-title">CO226 - 2023</h5>
                        <p class="card-text">Database Systems</p>
                    
                    </div>
                    <div class ="button-panel">

                        <div class="row">
                            <div class="col-sm-4">
                            <button class="btn btn-sm-3 btn-view">View</button>
                            </div>
                            <div class="col-sm-4">
                            <button class="btn btn-sm-3 btn-edit">Edit</button>
                            </div>
                            <div class="col-sm-4">
                            <button class="btn btn-sm-3 btn-delete">Delete</button>
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
.body {
    padding-top: 100px;
}


.card-body{
    background-color: #f2f2f2;
    padding: 5px;

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