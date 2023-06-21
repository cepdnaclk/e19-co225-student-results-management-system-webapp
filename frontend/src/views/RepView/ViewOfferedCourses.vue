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

                            <h5 class="card-title">CO224</h5>
                            <p class="card-text">Computer Architecture</p>

                            
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                    
                        <div class="card-body">
                            <h5 class="card-title">CO225</h5>
                            <p class="card-text">Software Construction</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card">
                    
                    <div class="card-body">
                        <h5 class="card-title">CO226</h5>
                        <p class="card-text">Database Systems</p>
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
    font-size: 35px;
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