<template>
    <div class="ar-logout">
        <img class="bg" src="@/assets/bg.png" alt="">
        <div id="logout-confirmation" class="hidden">
            <div class="confirmation-box">
                <h4>Are you sure you want to log out?</h4>
                <a id="logout-yes" class="btn btn-warning" href="#">Yes, log out</a>
                <a id="logout-no" class="btn btn-warning" href="#">Cancel</a>
            </div>
        </div>
    </div>
</template>

<style scoped>
.body {
    padding-top: 100px;
}

.btn {
    width: 80%;
    font-size: 30px;
    font-weight: 500;
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

#logout-confirmation {
    /* Styles for the logout confirmation box overlay */
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 999;
}

.confirmation-box {
    /* Styles for the logout confirmation box */
    background-color: white;
    padding: 20px;
    border-radius: 5px;
    text-align: center;
    /* Align the buttons to the center */
}

.confirmation-box .btn {
    /* Styles for the buttons */
    margin: 10px;
    width: 40%;
    font-size: 17px;
}

.hidden {
    /* Style to hide the logout confirmation box by default */
    display: none;
}

@media screen and (max-width: 768px) {
    .confirmation-box .btn {
        font-size: 14px;
    }

    .confirmation-box h3 {
        font-size: 18px;
    }
}

/* footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
} */
</style>