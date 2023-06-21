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
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>2. Dahanayake T.M.</td>
                        <td>E/19/058</td>
                        <td>Manufacturing & Industrial Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>3. Dassanayake D.M.S.I.</td>
                        <td>E/19/064</td>
                        <td>Civil Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>4. Liyanage A.L.D.N.</td>
                        <td>E/19/218</td>
                        <td>Mechanical Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
                        </div>
                    </tr>

                    <tr>
                        <td>5. Liyanage I.U.E.</td>
                        <td>E/19/221</td>
                        <td>Electrical & Electronic Engineering</td>
                        <div class="col-lg-12">
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-warning edit" href="#" role="button">Edit</a>
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

@media screen and (min-width: 1200px) {
    .filter {
        padding-left: 30px;
        padding-right: 20px;
        width: fit-content;
    }
}

@media screen and (max-width: 1440px) {
    .view {
        margin-left: 30px;
        margin-right: 25px;
    }
}

@media screen and (max-width: 1200px) {
    .view {
        margin-left: 11px;
        margin-right: 12px;
    }
}

@media screen and (max-width: 992px) {
    .view,
    .edit {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 90px;
        margin: 10px auto;
        margin-left: 20px;
    }
    .table td {
        font-size: 16px;
    }
}

@media screen and (max-width: 576px) {
    .view {
        margin-left: 5px;
        margin-right: 5px;
    }
}

@media screen and (max-width: 768px) {
    .view,
    .edit {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 80px;
        margin: 10px auto;
        margin-left: 20px;
    }
    .table td {
        font-size: 15px;
    }
}

@media screen and (max-width: 576px) {
    .view,
    .edit {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 60px;
        margin: 10px auto;
        margin-left: 10px;
    }
    .table td {
        font-size: 14px;
    }
}

@media screen and (max-width: 400px) {
    .col-form-label {
        width: auto;
        padding-right: 0;
    }
}
</style>
