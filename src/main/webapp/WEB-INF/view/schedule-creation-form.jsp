<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="/static/js/ajaxRequest.js"></script>
    <!-- Add icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.17.1/moment.min.js"></script>
    <link rel="stylesheet" href="https://rawgit.com/Eonasdan/bootstrap-datetimepicker/master/build/css/bootstrap-datetimepicker.min.css">
    <script src="https://rawgit.com/Eonasdan/bootstrap-datetimepicker/master/build/js/bootstrap-datetimepicker.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.all.min.js"></script>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'>

    <style>
        html,
        body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .input-box {
            display: table;
            margin: 20px;
            padding: 40px;
            background: #eee;
            box-shadow: 0 0 20px 1px rgba(0,0,0,.3);
            border-radius: 10px;
        }
        .input-box input[type="text"] {
            display: block;
            margin: 15px 0;
            padding: 0 10px;
            width: 400px;
            height: 36px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-shadow: inset 0 0 3px 1px rgba(0,0,0,.2);
        }
        .input-box input[type="text"]:focus {
            border: 1px solid #65c1ef;
        }
        .input-box input[type="submit"] {
            display: block;
            margin: 0;
            padding: 0 10px;
            width: 100px;
            height: 36px;
            font-size: 14px;
            background: #2090e1;
            border: 0;
            color: #fff;
            border-radius: 4px;
        }
        .input-box input[type="submit"]:hover {
            background: #187bc3;
            color: #eee;
            cursor: pointer;
        }
        [id^="datetimepicker"] {
            margin-bottom: 15px;
        }
        [id^="datetimepicker"] .form-control {
            margin: 0 !important;
        }

        #map {
            margin-left: -30px;
            height: 365px;
        }

        .navbar {
            background: #000000;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #434343, #000000);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #434343, #000000); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+*/
        }
    </style>
</head>
<body>
<!-- Page -->
<div class="container-fluid">

    <legend>
        <div class="fa-2x">
            <i class="fas fa-cog fa-spin"></i>
            <i class="text fa-1x">RattlerStation: manager tools</i>
            <i class="fas fa-cog fa-spin"></i>
        </div>
    </legend>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand fas fa-wrench" href="/managerTools"></a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/home">Home</a></li>
                <li><a href="#">Stations</a></li>
            </ul>
        </div>
    </nav>
    <br><br>
    <div class="row">
        <div class="col-md-6">
            <!-- Input form -->
            <div id="input">
                <div class="input-box">

                    <!-- Selection for data-list -->
                    <datalist id="stations"></datalist>

                    <form:form id="form" action="createSchedule" method="POST" modelAttribute="scheduleCreation">
                        <!-- Station departure -->
                        <form:input type="text" path="stationDepartureName" placeholder="From" name='begin' autocomplete='off' list='stations' id='station1'/>

                        <!-- Station arrival -->
                        <form:input type="text" path="stationArrivalName" placeholder="To" name='end' autocomplete='off' list='stations' id='station2'/>

                        <!-- Train -->
                        <form:input type="text" path="trainName" id="trainName" class="form-control" placeholder="Train name"/>

                        <!-- Date departure -->
                        <div class='input-group date col-sm-3' id='datetimepicker1'>
                            <form:input type="text" class="form-control" path="dateDeparture" id="dateDeparture" placeholder="Date departure"/>
                            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                        </div>

                        <input type="submit" value="Create">
                    </form:form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <!-- Google maps -->
            <div id="map"></div>

            <script>
                // Bootstrap date-time-picker config
                $('#datetimepicker1').datetimepicker({
                    defaultDate: new Date(),
                    format: 'YYYY-MM-DD HH:mm:ss',
                    sideBySide: true
                });

                var queue = [];
                var map;
                var picked = false;

                function initMap() {

                    // Map initialization
                    map = new google.maps.Map(document.getElementById('map'), {
                        center: {lat: 59.940266, lng: 30.313810},
                        zoom: 10,
                        styles: [{
                            "featureType": "all",
                            "elementType": "labels.text.fill",
                            "stylers": [{"saturation": 36}, {"color": "#000000"}, {"lightness": 40}]
                        }, {
                            "featureType": "all",
                            "elementType": "labels.text.stroke",
                            "stylers": [{"visibility": "on"}, {"color": "#000000"}, {"lightness": 16}]
                        }, {
                            "featureType": "all",
                            "elementType": "labels.icon",
                            "stylers": [{"visibility": "off"}]
                        }, {
                            "featureType": "administrative",
                            "elementType": "geometry.fill",
                            "stylers": [{"color": "#000000"}, {"lightness": 20}]
                        }, {
                            "featureType": "administrative",
                            "elementType": "geometry.stroke",
                            "stylers": [{"color": "#000000"}, {"lightness": 17}, {"weight": 1.2}]
                        }, {
                            "featureType": "landscape",
                            "elementType": "geometry",
                            "stylers": [{"color": "#000000"}, {"lightness": 20}]
                        }, {
                            "featureType": "poi",
                            "elementType": "geometry",
                            "stylers": [{"color": "#000000"}, {"lightness": 21}]
                        }, {
                            "featureType": "road.highway",
                            "elementType": "geometry.fill",
                            "stylers": [{"color": "#000000"}, {"lightness": 17}]
                        }, {
                            "featureType": "road.highway",
                            "elementType": "geometry.stroke",
                            "stylers": [{"color": "#000000"}, {"lightness": 29}, {"weight": 0.2}]
                        }, {
                            "featureType": "road.arterial",
                            "elementType": "geometry",
                            "stylers": [{"color": "#000000"}, {"lightness": 18}]
                        }, {
                            "featureType": "road.local",
                            "elementType": "geometry",
                            "stylers": [{"color": "#000000"}, {"lightness": 16}]
                        }, {
                            "featureType": "transit",
                            "elementType": "geometry",
                            "stylers": [{"color": "#000000"}, {"lightness": 19}]
                        }, {"featureType": "water", "elementType": "geometry", "stylers": [{"color": "#000000"}, {"lightness": 17}]}]
                    });

                    // Get REST data from controller via AJAX
                    var urlSearching = "/api/board/stations";
                    var stations = getRequest(urlSearching);

                    // Add current stations to datalist
                    var str=''; // variable to store the options
                    for (var i=0; i < stations.length;++i){
                        str += '<option value="'+stations[i].name+'" />'; // Storing options in variable
                    }

                    // Add array of stations to datalist
                    var my_list = document.getElementById("stations");
                    my_list.innerHTML = str;

                    // Add markers function
                    function addMarkerToMap(point) {
                        // Create marker
                        var marker = new google.maps.Marker({
                            position: {lat: point.latitude, lng: point.longitude},
                            map: map,
                            title: point.name
                        });

                        // Create listener for current marker
                        google.maps.event.addListener(marker,'click',function() {

                            // Create marker info window
                            var infoWindow = new google.maps.InfoWindow({
                                content: point.name
                            });

                            // For default case - open info window
                            infoWindow.open(map, marker);

                            // Station A -> Station B selection via form data (DOM HTML)
                            if (!picked) {
                                document.getElementById("form").elements[0].value = marker.title;
                                picked = true;
                            } else {
                                if (document.getElementById("form").elements[0].value === marker.title) {
                                    // Create alert with error message
                                    swal({
                                        type: 'error',
                                        title: 'Invalid input',
                                        text: 'Station departure and station arrival is the same station',
                                    });
                                } else {
                                    // Another loop of selections
                                    document.getElementById("form").elements[1].value = marker.title;
                                    picked = false;
                                }
                            }

                            // Synchronize array of info windows with station departure and station arrival input
                            if (queue.length === 0 || queue[queue.length - 1].content !== infoWindow.content)
                                queue.unshift(infoWindow); // Add info window to queue

                            if (queue.length === 3)
                                queue.pop().close(); // Pop first element and close it

                        });

                    }

                    // Add all stations with listeners to map
                    for (let i = 0; i < stations.length; i++) {
                        addMarkerToMap(stations[i]);
                    }
                }

            </script>
            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBDlLcHvt_VzI-31mvgHNtD_nyyTE9Qa5E&callback=initMap"></script>

        </div>
    </div>
</div>

<br><br><br>

<!-- Footer -->
<footer class="page-footer font-small black">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2018 Copyright:
        <a href="/home"> JavaSchool 27 RattlerStation</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
</div>

</body>
</html>