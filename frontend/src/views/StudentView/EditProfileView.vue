<template>
    <div class="student-edit">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <div class="change offset-lg-1">
                <h5>Change password</h5>
            </div>
            <form class="form mt-4">
                <div class="form-floating mb-3 col-lg-10 offset-lg-1">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Current Password</label>
                </div>
                <div class="form-floating mb-3 col-lg-10 offset-lg-1">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">New Password</label>
                </div>
                <div class="form-floating mb-3 col-lg-10 offset-lg-1">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Re-type Password</label>
                </div>
            </form>
            <div class="col-lg-12 text-center">
                <a class="btn btn-warning mt-2" href="#" role="button">Save changes</a>
            </div>
        </div>
    </div>
</template>

<style scoped>
.change {
    padding-top: 120px
}
/* .form {
    padding-top: 100px;
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

.navbar .current {
    color: white;
    font-weight: 500;
}

.btn {
    font-weight: 500;
}
</style>