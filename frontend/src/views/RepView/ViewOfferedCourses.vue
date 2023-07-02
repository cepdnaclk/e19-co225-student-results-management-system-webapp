<template>
    <div class="rep-viewcourses">
        <img class="bg" src="@/assets/bg.png" alt="">

        <div class="text-center">
            <router-link class="btn btn-warning col-lg-4 add" to="/rep/addcourses">+ Add New Course</router-link>
            <router-link class="btn btn-warning col-lg-4 view" to="/rep/viewcourses">View Courses</router-link>
        </div>

        <!-- subject cards -->
        <div class="container">
            <h4 class="mb-3">All courses available in the [dept name] department</h4>

            <!-- row-cols-md-3 is used to control how many card in a row -->
            <div class="row row-cols-4 row-cols-md-3 g-4">
                <div v-for="(courseOffered, index) in coursesOffered" :key="index" class="col">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">{{ courseOffered.course.code }}</h5>
                            <p class="card-text">{{ courseOffered.course.name }}</p>
                            <h6>{{ courseOffered.year }}</h6>
                        </div>
                        <div class="button-panel">
                            <div class="row">
                                <div class="col-sm-6">
                                    <router-link :to="`/rep/editcourses/${courseOffered.course.code}`"
                                        class="btn btn-sm-3 btn-edit">Edit</router-link>
                                </div>
                                <div class="col-sm-6">
                                    <button class="btn btn-sm-3 btn-delete"
                                        @click="deleteOfferedCourse(course.code)">Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import axios from "axios";
import { onMounted, ref } from "vue";

const coursesOffered = ref([])

const getCoursesOffered = async () => {
    try {
        const res = await axios.get("/courseOffering/");
        return res.data
    }
    catch (err) {
        console.log(err)
    }
}

const deleteOfferedCourse = (courseCode) => {
    axios
        .delete("/courseOffering/", {
            data: {
                Code: courseCode
            }
        })
        .then((res) => {
            console.log(res)
            getCoursesOffered()
        })
        .catch((err) => {
            console.log(err)
        })
}

onMounted(async () => {
    coursesOffered.value = await getCoursesOffered()
})
</script>

<style scoped>
.rep-viewcourses {
    padding: 2rem 0;
}


.card-body {
    background-color: #f2f2f2;
    padding: 5px;

    /* border-radius:10%; */
}

.card {
    background-color: #f06e6e;
    padding: 10px;
    height: 100%;
    /* border-radius:10%; */
}

.card h6 {
    font-size: 0.8rem;
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

.btn-view,
.btn-edit,
.btn-delete {
    margin-top: 10px;
    margin-bottom: 5px;
    margin-right: 5px;
    padding: 5px;
    font-size: 20px;
    font-weight: 100px;
    background-color: #f2f2f2;
    width: 100%;
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