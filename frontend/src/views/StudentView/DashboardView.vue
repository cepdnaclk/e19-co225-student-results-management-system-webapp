<template>
    <div class="student-dashboard">
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
      <h2>Targeted GPA for Semester 4:</h2>
      <input
        type="number"
        id="target-gpa-4"
        min="0"
        max="4"
        step="0.01"
        placeholder="Enter targeted GPA"
      />
    </div>
    <div class="card-panel">
      <h2>Targeted GPA for Semester 5:</h2>
      <input
        type="number"
        id="target-gpa-5"
        min="0"
        max="4"
        step="0.01"
        placeholder="Enter targeted GPA"
      />
    </div>
    <div class="card-panel">
      <h2>Targeted GPA for Semester 6:</h2>
      <input
        type="number"
        id="target-gpa-6"
        min="0"
        max="4"
        step="0.01"
        placeholder="Enter targeted GPA"
      />
    </div>
    <div class="card-panel">
      <h2>Targeted GPA for Semester 7:</h2>
      <input
        type="number"
        id="target-gpa-7"
        min="0"
        max="4"
        step="0.01"
        placeholder="Enter targeted GPA"
      />
    </div>
    <div class="card-panel">
      <h2>Targeted GPA for Semester 8:</h2>
      <input
        type="number"
        id="target-gpa-8"
        min="0"
        max="4"
        step="0.01"
        placeholder="Enter targeted GPA"
      />
    </div>
    <!-- Calculate button -->
    <div class="calculate-button">
      <button onclick="calculate()">Calculate</button>
    </div>
  </div>
  </div>
</template>

<style scoped>
/* .body {
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
} */


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
  align-items: center;
  margin-bottom: 20px;
  background-color: #eaf6ff;
  padding: 10px;
  border-radius: 4px;
  width: 100%;
}

.card-panel h2 {
  margin: 0;
  flex: 1;
  font-size: 14px;
}

.card-panel input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

/* New CSS for the Calculate button */
.calculate-button {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.calculate-button button {
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
}

.calculate-button button:hover {
  background-color: #45a049;
}
</style>

<script>
export default {
  data() {
    return {
      semesters: [4, 5, 6, 7, 8],
      targetGPAs: {
        4: null,
        5: null,
        6: null,
        7: null,
        8: null,
      },
      gpaResult: null,
      rankResult: null,
    };
  },
  methods: {
    calculate() {
      // Get the input values for each semester
      const targetGPAs = Object.values(this.targetGPAs);

      // Perform your GPA and Rank calculations here
      // ...
      // Replace the following dummy values with your actual calculations
      this.gpaResult = 3.75;
      this.rankResult = 5;
    },
  },
  mounted() {
    // Fetch data function
    this.fetchData();
  },
  methods: {
    fetchData() {
      fetch('gpa-data.json')
        .then(response => response.json())
        .then(data => {
          this.gpaResult = data.gpa.toFixed(2);
        })
        .catch(error => console.error(error));

      fetch('rank-data.json')
        .then(response => response.json())
        .then(data => {
          this.rankResult = data.rank;
        })
        .catch(error => console.error(error));
    },
  },
};
</script>

