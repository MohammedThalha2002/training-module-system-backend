const report = document.getElementById("report");

async function fetchingCourses() {
  await axios.get("http://localhost:8080/module/get-modules").then((res) => {
    console.log(res.data);
    const courses = res.data;
    fetchingEmployees(courses);
  });
}

async function fetchingEmployees(courses) {
  await axios
      .get("http://localhost:8080/employee/get-employees")
      .then((res) => {
        console.log(res.data);
        const employees = res.data;
        render(courses, employees);
      });
}

function render(courses, employees) {
  // console.log(courses);

  courses.forEach((course, index) => {
    report.innerHTML += `
    <div class="mb-4">
        <div class="row">
          <div class="col-md-6">
            <div class="card">
              <div class="card-header">Course Information</div>
              <div class="card-body">
                <h5 class="card-title">Course Name: ${course.name}</h5>
                <p class="card-text">
                  Description: ${course.description}
                </p>
              </div>
            </div>
          </div>
        </div>

        <div class="row mt-4">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">Employee Progress</div>
              <div class="card-body">
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Employee Name</th>
                      <th scope="col">Progress</th>
                    </tr>
                  </thead>
                  <tbody id="${course.name}">

                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    `;

    let empIdName = document.getElementById(course.name);
    let filteredEmployees = employees.filter(
        (employee) =>
            employee.trainingModule && employee.trainingModule.name == course.name
    );
    console.log(filteredEmployees);
    filteredEmployees.forEach((emp, i) => {
      empIdName.innerHTML += `
            <tr>
                <th scope="row">${i + 1}</th>
                <td>${emp.name}</td>
                <td>${emp.progress}%</td>
            </tr>
        `;
    });
  });
}

fetchingCourses();

function generatePDFReport() {
  var pdf = new jsPDF("p", "pt", "letter");
  pdf.canvas.height = 72 * 11;
  pdf.canvas.width = 72 * 8.5;

  pdf.fromHTML(document.getElementById("report-pdf"));

  pdf.save("report.pdf");
}
