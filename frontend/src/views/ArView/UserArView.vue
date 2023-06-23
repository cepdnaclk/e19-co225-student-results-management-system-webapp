<template>
    <div class="ar-user">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container body">
            <div class="row justify-content-center">
                <div class="col-lg-10">
                    <div class="input-group">
                        <input type="text" class="form-control form-control-sm" placeholder="Search">
                        <button class="btn btn-primary btn-md" type="button">Search</button>
                    </div>
                </div>
            </div>
            <div class="row mt-md-3 align-items-center justify-content-center gap-md-0 gap-3 mt-5">
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example">
                        <option selected>Sort By</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                    </select>
                </div>
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example">
                        <option selected>Filter By</option>
                        <option>17</option>
                        <option>18</option>
                        <option>19</option>
                        <option>20</option>
                    </select>
                </div>
                <div class="col-lg-2 col-md-3">
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
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example">
                        <option selected>User Type</option>
                        <option>Student</option>
                        <option>Representative</option>
                        <option>Coordinator</option>
                    </select>
                </div>
            </div>

            <table class="table table-borderless mt-5">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Registration number</th>
                        <th scope="col">Department</th>

                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" :key="user.id">
                        <td>{{ user.honorific + ". " + user.initials + user.lastName }}</td>
                        <td>{{ user.userName }}</td>
                        <td>{{ user.deptId }}</td>
                        <div>
                            <a class="btn btn-warning view" href="#" role="button">View</a>
                            <a class="btn btn-success" href="#" role="button">Edit</a>
                        </div>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
import axios from "axios"
import { ref } from "vue";

const users = ref([]);

axios
    .get("/user/")
    .then((res) => {
        users.value = res.data;
    })
    .catch((err) => {
        console.log(err)
    })
</script>

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

.table tbody tr:nth-child(2n-1) td {
    background-color: #f3f4f5;
}

.table td {
    border-top: none;
    padding: 1rem;
}

.table tr div {
    background: none;
    margin: 0;
    width: fit-content;
}

.table tr td:first-child {
    text-align: left;
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
</style>
