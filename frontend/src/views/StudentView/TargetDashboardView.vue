<template>
  <div>
    <div class="container">
      <div class="card">
        <h2>Your GPA after sem 3</h2>
        <div class="result" id="gpa-result"></div>
      </div>
      <div class="card">
        <h2>Departmental Rank</h2>
        <div class="result" id="rank-result"></div>
      </div>
    </div>

    <div class="box-list">
      <div class="card-panel">
        <h2>Grades to achieve targeted GPA semester 3</h2>
        <p>
          A+/A: &nbsp;| A-: &nbsp;| B+: &nbsp;| B: &nbsp;| B-: &nbsp;| C+:
          &nbsp;| C: &nbsp;
        </p>
      </div>
      <div class="card-panel">
        <h2>Grades to achieve targeted GPA semester 4</h2>
        <p>
          A+/A: &nbsp;| A-: &nbsp;| B+: &nbsp;| B: &nbsp;| B-: &nbsp;| C+:
          &nbsp;| C: &nbsp;
        </p>
      </div>
      <div class="buttons">
        <button id="save-button" @click="handleSave">Save</button>
        <button id="recalculate-button" @click="handleRecalculate">
          Recalculate
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleSave() {
      alert("Save button clicked!");
      // Add your save functionality here
    },
    handleRecalculate() {
      alert("Recalculate button clicked!");
      // Add your recalculate functionality here
    },
  },
};
</script>

<style scoped>
/* Add the CSS styles here */

body {
  font-family: Arial, sans-serif;
  background-color: #f1f1f1;
  margin: 0;
  padding: 20px;
}

.container {
  margin-top: 120px;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 25vh;
  margin-bottom: 40px;
}

.card {
  width: 350px;
  height: 180px;
  background-color: #fff;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  padding: 20px;
  text-align: center;
}

h2 {
  margin-top: 0;
  margin-bottom: 20px;
  color: #333;
}

.result {
  font-weight: bold;
  margin-bottom: 20px;
  font-size: 18px;
}

.card + .card {
  margin-left: 40px;
}

.box-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #f1f1f1;
  padding: 20px;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-left: auto;
  margin-right: auto;
  max-width: 800px;
  width: 100%;
  margin-bottom: 25vh;
}

.card-panel {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
  background-color: #eaf6ff;
  padding: 10px;
  border-radius: 4px;
  width: 100%;
}

.card-panel h2 {
  margin: 0;
  font-size: 14px;
}

.card-panel p {
  margin: 5px;
  display: inline-block;
}

.buttons {
  margin-top: 20px;
}

.buttons button {
  background-color: #4caf50;
  color: white;
  border: none;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-right: 10px;
}

.buttons button:hover {
  background-color: #45a049;
}
</style>
