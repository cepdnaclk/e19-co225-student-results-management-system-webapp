<template>
  <div class="student-home">
    <img class="bg" src="@/assets/bg.png" alt="">
    <div class="container">
      <div class="card">
        <h2 class="name">John Doe</h2>
      </div>

      <div class="card">
        <p class="quote">"The future belongs to those who believe in the beauty of their dreams."</p>
      </div>
    </div>
    <div class="notification-container">
      <div class="notification-box">
        <div class="notification-card">
          <h3 class="notification-title">Notification 1</h3>
          <p class="notification-message">This is the first notification.</p>
        </div>

        <div class="notification-card">
          <h3 class="notification-title">Notification 2</h3>
          <p class="notification-message">This is the second notification.</p>
        </div>

        <div class="notification-card">
          <h3 class="notification-title">Notification 3</h3>
          <p class="notification-message">This is the third notification.</p>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.body {
  padding-top: 100px;
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

.container {
  margin-top: 120px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 25vh;
}

.card {
  width: 350px;
  height: 150px;
  padding: 20px;
  margin: 20px;
  background-color: #f2f2f2;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.name {
  font-size: 20px;
  font-weight: bold;
}

.quote {
  margin-top: 10px;
  font-style: italic;
}

.notification-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
}

.notification-box {
  width: 400px;
  padding: 10px;
  background-color: #e6e6e6;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.notification-card {
  padding: 10px;
  margin-bottom: 10px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.notification-title {
  font-weight: bold;
  margin-bottom: 5px;
}

.notification-message {
  font-size: 14px;
  font-style: italic;
}

/* footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
} */
</style>