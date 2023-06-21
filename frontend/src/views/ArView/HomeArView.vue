<template>
    <div class="ar-home">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div class="container">
            <div class="col-lg-6 offset-lg-3 text-center">
                <a class="btn btn-warning add" href="#">Add User</a>
            </div>
            <div class="col-lg-6 offset-lg-3 text-center">
                <a class="btn btn-warning view" href="#">View User</a>
            </div>
        </div>
    </div>
</template>

<style scoped>
.body {
    padding-top: 100px;
}


.btn {
    font-size: 35px;
    font-weight: 400;
    padding: 15px 50px;
}

.add {
    margin-top: 200px;
    margin-bottom: 100px;
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