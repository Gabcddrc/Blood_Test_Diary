function searchHospitalFunction() {
    let input, filter, table, tr, td, i;
    input = document.getElementById("name");
    filter = input.value.toUpperCase();
    table = document.getElementById("hospitalTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

  var map;

  function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
      center: {
        lat: 51.508530,
        lng: -0.076132
      }, //London
      zoom: 10
    });
    //var geocoder = new google.maps.Geocoder();
    //document.getElementById('showHospital').addEventListener('click',function(){
    //  geocodeAddress(geocoder,map);
    //});
  }

  function buttonHelper(address) {
    geocodeAddress(map, address, "FE7569");
  }





  function geocodeAddress(resultsMap, address, pinColor) {
      //Set Color of marker
      var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + pinColor,
          new google.maps.Size(18, 34),
          new google.maps.Point(0,0),
          new google.maps.Point(10, 34));

    var geocoder = new google.maps.Geocoder(); //Test
    geocoder.geocode({
      'address': address
    }, function (results, status) {
      if (status === 'OK') {
        resultsMap.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
          map: resultsMap,
          position: results[0].geometry.location,
            icon: pinImage

        });
        resultsMap.setZoom(15);
      } else {
        alert('Not successful for the following reason: ' + status);
      }
    });
  }







function searchPatientLocation(){
    let input;

    input = document.getElementById("patient_location");
    filter = input.value.toLowerCase();

    geocodeAddress(map, filter,"9400D3");
  }


