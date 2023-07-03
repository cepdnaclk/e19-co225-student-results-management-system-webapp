<template>
    <div class="student-courseinner">
      <img class="bg" src="@/assets/bg.png" alt="">
      <div class="container">
        <h4>All courses available in the [dept name] department</h4>
  
        <div class="row row-cols-4 row-cols-md-1 g-4">
          <div class="col">
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="col-3">
                    <h5 class="card-title">Lab</h5>
                  </div>
                  <div class="col-2"></div>
                  <div class="col-3"></div>
                  <div class="col-2">
                    <h5 class="card-text text-end">Allocated % : 30%</h5>
                  </div>
                </div>
                <hr class="horizontal-line">
                <div class="row">
                  <div class="col-5">
                    <h5>Lab 1 : Name</h5>
                  </div>
                  <div class="col-2"></div>
                  <div class="col-2"></div>
                  <div class="col-2"></div>
                </div>
                <div class="row">
                  <div class="col-5">
                    <h5>Lab 2 : Name</h5>
                  </div>
                  <div class="col-2"></div>
                  <div class="col-2"></div>
                  <div class="col-2"></div>
                </div>
                <div class="row">
                  <div class="col-sm-4"></div>
                </div>
              </div>
  
              <div class="card-body">
                <div class="row">
                  <div class="col-3">
                    <h5 class="card-title">Assignments</h5>
                  </div>
                  <div class="col-7">
                    <h5 class="card-text text-end">Allocated % : xx%</h5>
                  </div>
                </div>
                <hr class="horizontal-line">
                <form class="row">
                  <label for="activity_name" class="col-sm-2 col-form-label text-field">Activity Name</label>
                  <div class="col-3"></div>
                  <label for="max_marks" class="col-sm-2 col-form-label text-field">Max Marks</label>
                  <div class="col-2"></div>
                  <div class="col-1"></div>
                </form>
              </div>
  
              <div class="card-body">
                <div class="row">
                  <div class="col-3">
                    <h5 class="card-title">Assignments</h5>
                  </div>
                  <div class="col-2"></div>
                  <div class="col-3"></div>
                  <div class="col-2">
                    <h5 class="card-text text-end">Allocated % : xx%</h5>
                  </div>
                </div>
                <hr class="horizontal-line">
                <div class="row">
                  <div class="col-sm-4"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <style scoped>
  .student-courseinner {
    padding-top: 7rem;
  }
  
  .row {
    padding: 5px;
  }
  
  .card-body {
    background-color: #f2f2f2;
    padding: 5px;
    margin-bottom: 10px;
  }
  
  .card {
    background-color: #f06e6e;
    padding: 10px;
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
  
  </style>
  