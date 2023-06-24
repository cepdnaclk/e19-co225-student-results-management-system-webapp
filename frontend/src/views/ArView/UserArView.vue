<template>
    <div class="ar-user">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container body">
            <div class="row justify-content-center">
                <div class="col-lg-10">
                    <div class="input-group">
                        <input type="text" class="form-control form-control-sm" placeholder="Search" v-model="searchTxt">
                    </div>
                </div>
            </div>
            <div class="row mt-md-3 align-items-center justify-content-center gap-md-0 gap-3 mt-5">
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example" v-model="sortBy">
                        <option value="" selected>Sort By</option>
                        <option value="name">Name</option>
                        <option value="eno">E no.</option>
                        <option value="dept">Depertment</option>
                    </select>
                </div>
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example" v-model="userYear">
                        <option selected value="">Batch</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                    </select>
                </div>
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example" v-model="userDept">
                        <option value="" selected>Department</option>
                        <option value="co">Computer Engineering</option>
                        <option value="ee">Electrical & Electronic Engineering</option>
                        <option value="cp">Chemical & Process Engineering</option>
                        <option value="me">Mechanical Engineering</option>
                        <option value="mi">Manufacturing & Industrial Engineering</option>
                        <option value="ce">Civil Engineering</option>
                    </select>
                </div>
                <div class="col-lg-2 col-md-3">
                    <select class="form-select form-select-sm" aria-label="Default select example" v-model="userRole">
                        <option value="" selected>User Type</option>
                        <option value="student">Student</option>
                        <option value="representator">Representative</option>
                        <option value="cordinator">Coordinator</option>
                    </select>
                </div>
            </div>

            <table class="table table-borderless mt-5">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Registration number</th>
                        <th scope="col">Department</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <transition name="fade" mode="out-in">
                    <TransitionGroup v-if="filteredUsers.length" name="list" tag="tbody" appear>
                        <tr v-for="user in filteredUsers" :key="user.id">
                            <td>{{ user.name }}</td>
                            <td>{{ user.eno }}</td>
                            <td>{{ user.dept }}</td>
                            <td> <a class="btn btn-warning view" href="#" role="button">View</a> </td>
                            <td><a class="btn btn-success" href="#" role="button">Edit</a></td>
                        </tr>
                    </TransitionGroup>
                    <tr v-else>
                        <td colspan="3" class="text-center mt-2">There are no users</td>
                    </tr>
                </transition>
            </table>
        </div>
    </div>
</template>

<script setup>
import axios from "axios"
import { computed, ref } from "vue";

const result = ref([])
const searchTxt = ref("")
const userRole = ref("")
const userYear = ref("")
const userDept = ref("")
const sortBy = ref("")
const users = computed(() => {
    let array = []
    result.value.forEach((ele) => {
        const objUser = {
            id: ele.id,
            name: ele.honorific + ". " + ele.initials + " " + ele.lastName,
            eno: ele.userName || "",
            dept: ele.deptId || "",
            role: ele.role,
        }
        array.push(objUser)
    })
    return array
})
const filteredUsers = computed(() => {
    let array = users.value
    if (searchTxt.value != "") {
        array = array.filter(user =>
            user.name.toLowerCase().includes(searchTxt.value.toLowerCase()) ||
            user.eno.toLowerCase().includes(searchTxt.value.toLowerCase())
        )
    }
    if (userRole.value != "") {
        array = array.filter(user =>
            user.role.toLowerCase().includes(userRole.value.toLowerCase())
        )
    }
    if (userYear.value != "") {
        array = array.filter(user =>
            user.eno.toLowerCase().includes("e/" + userYear.value.toLowerCase())
        )
    }
    if (userDept.value != "") {
        array = array.filter(user =>
            user.dept.toLowerCase().includes(userDept.value.toLowerCase())
        )
    }
    if (sortBy.value != "") {
        array = array.sort(function (a, b) {
            return a[sortBy.value].localeCompare(b[sortBy.value]);
        });
    }

    return array
})

axios
    .get("/user/")
    .then((res) => {
        result.value = res.data;
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

.table thead th:nth-child(4),
.table thead th:nth-child(5) {
    width: 30px;
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

.table thead tr th:first-child {
    text-align: left !important;
    padding-left: 1.1rem
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

.list-move,
/* apply transition to moving elements */
.list-enter-active,
.list-leave-active {
    transition: all 0.5s ease;
}

.list-enter-from,
.list-leave-to {
    opacity: 0;
    transform: translateX(30px);
}

/* ensure leaving items are taken out of layout flow so that moving
   animations can be calculated correctly. */
.list-leave-active {
    position: absolute;
}
</style>
