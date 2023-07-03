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
                        <comp-assessment-type @changed="loadAssesments()"
                            v-for="(assesment, key, index) in groupedAssessments" :assesment="assesment" :key="index"
                            :type="key" />
                        <!-- after clicking add item button -->

                        <div class="card-body">

                            <form @submit.prevent="addType()" class="row">

                                <label for="assessment_name" class="col-sm-2 col-form-label text-field">Activity
                                    Name</label>
                                <div class="col-sm">
                                    <input type="text" class="form-control" id="assessment_name" placeholder="Enter name"
                                        v-model="typeName">
                                </div>
                            </form>

                            <hr class="horizontal-line">

                            <div class="col-sm-4">
                                <button class="btn btn-sm-3 btn-add-item" @click="addType()">Save item</button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useStore } from "vuex";
import axios from "axios";
import { onMounted, ref } from "vue";
import compAssessmentType from "@/components/compAssessmentType.vue";
import { useRouter } from "vue-router";

const store = useStore()
const router = useRouter()
const groupedAssessments = ref({})
const typeName = ref()

const addType = () => {
    groupedAssessments.value[typeName.value] = []
    typeName.value = ""
}

const loadAssesments = async () => {
    try {
        const res = await axios.post("/assesment/get", {
            ...store.state.editingCourseOffered,
        })
        console.log(res)
        groupedAssessments.value = res.data.reduce((result, assessment) => {
            const type = assessment.type;

            if (!result[type]) {
                result[type] = [];
            }

            result[type].push(assessment);

            return result;
        }, {});

        groupedAssessments.value = { ...groupedAssessments.value }
    }
    catch (err) {
        console.log(err)
        router.push("/rep/viewofferedcourses")
    }
}

onMounted(() => {
    loadAssesments()
})
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