<template>
    <div class="card-body">
        <div class="row">
            <div class="col-3">
                <h5 class="card-title">{{ props.type }}</h5>
            </div>
        </div>
        <hr class="horizontal-line">
        <div class="row" v-for="(asses, index) in assesment" :key="index">
            <div class="col-5">
                <h5>{{ asses.name }} </h5>
            </div>
            <div class="col-2">
            </div>
            <div class="col-2">
                <button class="btn btn-sm-3 btn-assessment-title" @click="deleteAssesment(asses.assesId)">Delete</button>
            </div>
            <div class="col-2">
                <button class="btn btn-sm-3 btn-activity-title" href="#">Request Results</button>
            </div>
        </div>
        <form class="row" @submit.prevent="addAssesment()">

            <label for="activity_name" class="col-sm-2 col-form-label text-field">Activity Name</label>
            <div class="col-3">
                <input type="text" class="form-control" id="activity_name" v-model="name" placeholder="Enter name">
            </div>

            <label for="max_marks" class="col-sm-2 col-form-label text-field">Max Marks</label>
            <div class="col-2">
                <input type="text" class="form-control" id="max_marks" v-model="maxMarks" placeholder="Max Marks">
            </div>

            <div class="col-1">
                <button class="btn btn-sm-3 btn-save-item">Save item</button>
            </div>

        </form>
    </div>
</template>

<script setup>
import store from '@/store';
import { ref } from 'vue';
import axios from 'axios';

const props = defineProps(["assesment", "type"])
const emits = defineEmits(["changed"])
const assesment = ref(props.assesment)
const name = ref()
const maxMarks = ref()

const addAssesment = () => {
    const AddAssesment = {
        name: name.value,
        type: props.type,
        max_marks: maxMarks.value,
        courseOfferingDTO: store.state.editingCourseOffered
    }
    axios
        .post("/assesment/", AddAssesment)
        .then((res) => {
            console.log(res)
            $emit("changed")
        })
        .catch((err) => {
            console.log(err)
        })
}

const deleteAssesment = () => {
    axios.delete("/assesment/")
        .then()
}
</script>

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