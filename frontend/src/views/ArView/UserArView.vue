<template>
    <div class="ar-user">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container body">
            <div class="row">
                <div class="col-xl-10 col-md-12">
                    <div class="input-group">
                        <input type="text" class="form-control form-control-sm" placeholder="Search">
                        <button class="btn btn-primary btn-md" type="button">Search</button>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-xl-12">
                    <div class="row">
                        <label for="sort" class="col-xl-1 col-form-label pr-1">Sort by</label>
                        <div class="col-xl-2 col-lg-2">
                            <select class="form-select form-select-sm" aria-label="Default select example">
                                <option selected>Sort</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <label for="filter" class="col-xl-2 col-md-6 col-form-label filter">Filter by</label>
                        <div class="col-xl-2 col-lg-2">
                            <select class="form-select form-select-sm" aria-label="Default select example">
                                <option selected>Batch</option>
                                <option>17</option>
                                <option>18</option>
                                <option>19</option>
                                <option>20</option>
                            </select>
                        </div>
                        <div class="col-xl-2 col-lg-3">
                            <select class="form-select form-select-sm" aria-label="Default select example">
                                <option selected>Department</option>
                                <option>Computer Engineering</option>
                                <option>Electrical & Electronic Engineering</option>
                                <option>Chemical & Process Engineering</option>
                                <option>Mechanical Engineering</option>
                                <option>Manufacturing & Industrial Engineering</option>
                                <option>Civil Engineering</option>
                            </select>
                        </div>
                        <div class="col-xl-2 col-lg-3">
                            <select class="form-select form-select-sm" aria-label="Default select example">
                                <option selected>User Type</option>
                                <option>Student</option>
                                <option>Representative</option>
                                <option>Coordinator</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <!-- <div class="row mt-333">
            <div class="col-sm-12">
                <div class="row">
                    <label for="filter" class="col-sm-2 col-md-2 col-form-label">Filter by</label>
                    <div class="col-sm-4 col-md-2">
                        <select class="form-select form-select-sm" aria-label="Default select example">
                            <option selected>Batch</option>
                            <option>17</option>
                            <option>18</option>
                            <option>19</option>
                            <option>20</option>
                        </select>
                    </div>
                    <div class="col-sm-4 col-md-2">
                        <select class="form-select form-select-sm" aria-label="Default select example">
                            <option selected>Department</option>
                            <option>Computer Engineering</option>
                            <option>Electrical & Electronic Engineering</option>
                            <option>Chemical & Process Engineering</option>
                            <option>Mechanical Engineering</option>
                            <option>Manufacturing & Industrial Engineering</option>
                            <option>Civil Engineering</option>
                        </select>
                    </div>
                    <div class="col-sm-4 col-md-2">
                        <select class="form-select form-select-sm" aria-label="Default select example">
                            <option selected>User Type</option>
                            <option>Student</option>
                            <option>Representative</option>
                            <option>Coordinator</option>
                        </select>
                    </div>
                </div>
            </div>
        </div> -->

            <table class="table table-borderless mt-5">
                <thead>
                    <tr>
                        <th scope="col" class="col-xl-3 col-lg-4">Name</th>
                        <th scope="col" class="col-xl-2 col-lg-2">Registration number</th>
                        <th scope="col" class="col-xl-3 col-lg-4">Department</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1. Dissanayake D.M.I.G.</td>
                        <td>E/19/090</td>
                        <td>Computer Engineering</td>
                        <div>
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12 col-sm-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Avinash K.T.D.</td>
                        <td>E/19/029</td>
                        <td>Computer Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning" href="#" role="button">Edit</a>
                        </div>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<style scoped>
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

.ar-user {
    margin-top: 120px;
}

.table {
    border: none;
    margin-bottom: 4rem;
    width: 120%;
    /*100% after md */
}

.table thead th {
    padding: 30px 0;
    text-align: center;
}

.table tbody td {
    text-align: center;
}

.table tbody tr:nth-child(odd) td {
    background-color: #f3f4f5;
}

.table td {
    border-top: none;
    padding: 1rem;
}

div .col-lg-12 {
    background: none;
}

.view {
    margin-left: 40px;
    margin-right: 30px;
}

.col-form-label {
    width: 80px;
    padding-right: 1px;
}

.col-lg-4 {
    flex: 0 0 auto;
    width: 16.66666667%;
}

.filter {
    padding-right: 20px;
    padding-left: 60px;
    width: fit-content;
}

footer {
    background-color: #2c3e50;
    padding: 0;
    text-align: center;
    font-size: 14px;
    justify-content: center;
    align-items: center;
}

.list-inline-item {
    text-align: center;
    padding: 20px 5px;
    margin: 10px;
    color: white;
}

.list-inline li {
    display: inline-block;
    margin-right: 10px;
}

.list-inline li a {
    text-decoration: none;
    color: rgba(255, 255, 255, 0.5);
    font-weight: 400;
}

.list-inline li a:hover {
    color: white;
}
</style>
