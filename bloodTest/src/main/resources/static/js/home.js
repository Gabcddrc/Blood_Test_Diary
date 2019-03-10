function filter(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("flag");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[8];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function searchTestFunction() {
    var input, filter, table, tr, td, i;
    input = document.getElementById("patient");
    filter = input.value.toUpperCase();
    table = document.getElementById("testTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[2];
      if (td) {
        if (td.innerHTML.toUpperCase().includes(filter)) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

$(document).ready(function () {
    $("#1").click(function () {
      $("#red").click(function () {
        document.getElementById("b1").className = "badge red";
      });
    });
  });

