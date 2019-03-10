function filter(fill) {
  var input, filter, table, tr, td, i;
  input = document.getElementById("flag");
  filter = fill.toUpperCase();
  table = document.getElementById("testTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[9];
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

  $('#login-form').on('submit', function (event) {

    var self = this;
    var form = $(this);
    var errorMsg = $('#errorMsg');


    if (form.data('requestRunning')) {
      return;
    }

    form.data('requestRunning', true);
    event.preventDefault();
    $.ajax({
      url: form.attr("th:action"),
      type: form.attr("method"),
      data: form.serialize(),
      success: function (result) {

        console.log(hi);
        if (result.login == undefined) {
          self.submit();
        } else {
          errorMsg.text(result.login.FAILURE).addClass("alert alert-danger");
        }

      },
      complete: function (e) {
        form.data('requestRunning', false);
      }

    });

  });

