function filterFlag(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("flag");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[7];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function filterComplete(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("completed");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
    if (td) {
      if (td.innerHTML.toUpperCase().includes(filter)) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

function filterMissTest(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("missTest");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  if (filter != "") {
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[6];
      if (td) {
        if(filter == "1" && td.innerHTML.toUpperCase() == "0")
        {
          tr[i].style.display = "";
        } 
        else if(filter == "2" && td.innerHTML.toUpperCase() != "0"){
          tr[i].style.display = "";
        }
        else {
          tr[i].style.display = "none";
        }
      }
    }
  }
}

function searchTestFunction() {
  let input, filter, table, tr, td, i;
  input = document.getElementById("name");
  filter = input.value.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
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