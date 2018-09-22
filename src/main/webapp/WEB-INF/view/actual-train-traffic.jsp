<!-- JSP for schedule selection -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Actual train traffic</title>
    <script type="text/javascript" src="/static/js/jquery-1.11.2.js"></script>
    <script type="text/javascript" src="/static/js/jcanvas.js"></script>
    <link type="text/css" rel="stylesheet" href="/static/css/schedule-map.css" />
    <!-- Add bootstrap and datepicker -->
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="/static/js/moment.min.js"></script>
    <link rel="stylesheet"
          href="/static/css/bootstrap-datetimepicker.min.css">
    <script src="/static/js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
<div id='top'>
    Rattler Station
</div>
<div id='content'>

    <h2>Booking ticket</h2>

    <div id='input_box'>
        <form:form method="POST" action="buyTicket"  modelAttribute="schedule">

            <legend>Actual train traffic</legend>

            <form:input type="hidden" path="id" id="id"/>
            <form:input type="text" path="stationDepartureName" placeholder="From" name='begin' autocomplete='off' list='stations_list' id='station1'/>
            <br> <br>
            <form:input type="text" path="stationArrivalName" placeholder="To" name='end' autocomplete='off' list='stations_list' id='station2'/>
            <br> <br>
            <!-- Add bootstrap datepicker input field -->
            <div class="container">
                <div class="row">
                    <div class='col-sm-3'>
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker1'>
                                <form:input type="text" class="form-control" path="dateDeparture" id="dateDeparture" placeholder="Date departure"/>
                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                            </div>
                            <br><br>
                            <div class='input-group date' id='datetimepicker2'>
                                <form:input type="text" class="form-control" path="dateArrival" id="dateArrival" placeholder="Date arrival"/>
                                <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br><br>
            <datalist id='stations_list'>

                <option> Finlyandskiy vokzal </option>

                <option> Piskarevka </option>

                <option> Ruchiy </option>

                <option> Murino </option>

                <option> Deviatkino </option>

                <option> Lavriki </option>

                <option> Kapitolovo </option>

                <option> Kuzmolovo </option>

                <option> Toksovo </option>

                <option> Kavgolovo </option>

                <option> Oselki </option>

                <option> Peri </option>

                <option> 39 KM </option>

                <option> Gruzino </option>

                <option> Udelnaya </option>

                <option> Ozerki </option>

                <option> Zvezdnaya </option>

                <option> Shuvalovo </option>

                <option> Pargalovo </option>

                <option> Levashovo </option>

                <option> Pesochnaya </option>

                <option> Dibuni </option>

                <option> Beloostrov </option>

                <option> Solnechnoe </option>

                <option> Novaya Derevniya </option>

                <option> Staraya Derevnya </option>

                <option> Yaztennaya </option>

                <option> Laxta </option>

                <option> Olgino </option>

                <option> Lisiy Nos </option>

                <option> Gorskaya </option>

                <option> Alexandrovskaya </option>

                <option> Tarxovka </option>

                <option> Razliv </option>

                <option> Sestroretsk </option>

                <option> Kurort </option>

                <option> Repino </option>

                <option> Komarovo </option>

                <option> Zelenogorsk </option>

                <option> Ushkovo </option>

                <option> Roshino </option>

                <option> 63 KM </option>

                <option> Gorkovskoe </option>

                <option> Shevelevo </option>

                <option> Kaneliarvi </option>

                <option> Zahodskoye </option>

                <option> Kirillovskoe </option>

                <option> Leypsya </option>

                <option> Lebedevka </option>

                <option> 117 KM </option>

                <option> Verxne-Cherkasovo </option>

                <option> Lazoreva </option>

                <option> Viborg </option>

                <option> Sadovaya </option>

                <option> Molodeshnaya </option>

                <option> Privetenskoe </option>

                <option> 70 KM </option>

                <option> 72 KM </option>

                <option> Masteryarvi </option>

                <option> Yapilia </option>

                <option> 86 KM </option>

                <option> Tarasovskoe </option>

                <option> Kyolemoyarvi </option>

                <option> 106 KM </option>

                <option> Ermilovo </option>

                <option> Primorsk </option>

                <option> Bor </option>


            </datalist>
            <input type='submit' value='Enter' id='submit'>
            <br> <br>
            <div id='result'>


            </div>
        </form:form>
    </div>

    <div id='map'>
        <img src="/static/images/schedule-map.png" id='image' width="700" height="650"/>
        <div id='stat_1'> Finlyandskiy vokzal </div>
        <div id='stat_2'> Piskarevka </div>
        <div id='stat_3'> Ruchiy </div>
        <div id='stat_4'> Murino </div>
        <div id='stat_5'> Deviatkino </div>
        <div id='stat_6'> Lavriki </div>
        <div id='stat_7'> Kapitolovo </div>
        <div id='stat_8'> Kuzmolovo </div>
        <div id='stat_9'> Toksovo </div>
        <div id='stat_10'> Kavgolovo </div>
        <div id='stat_11'> Oselki </div>
        <div id='stat_12'> Peri </div>
        <div id='stat_13'> 39 KM </div>
        <div id='stat_14'> Gruzino </div>
        <div id='stat_15'> Udelnaya </div>
        <div id='stat_16'> Ozerki </div>
        <div id='stat_17'> Zvezdnaya </div>
        <div id='stat_18'> Shuvalovo </div>
        <div id='stat_19'> Pargalovo </div>
        <div id='stat_20'> Levashovo </div>
        <div id='stat_21'> Pesochnaya </div>
        <div id='stat_22'> Dibuni </div>
        <div id='stat_23'> Beloostrov </div>
        <div id='stat_24'> Solnechnoe </div>
        <div id='stat_25'> Novaya Derevniya </div>
        <div id='stat_26'> Staraya Derevnya </div>
        <div id='stat_27'> Yaztennaya </div>
        <div id='stat_28'> Laxta </div>
        <div id='stat_29'> Olgino </div>
        <div id='stat_30'> Lisiy Nos </div>
        <div id='stat_31'> Gorskaya </div>
        <div id='stat_32'> Alexandrovskaya </div>
        <div id='stat_33'> Tarxovka </div>
        <div id='stat_34'> Razliv </div>
        <div id='stat_35'> Sestroretsk </div>
        <div id='stat_36'> Kurort </div>
        <div id='stat_37'> Repino </div>
        <div id='stat_38'> Komarovo </div>
        <div id='stat_39'> Zelenogorsk </div>
        <div id='stat_40'> Ushkovo </div>
        <div id='stat_41'> Roshino </div>
        <div id='stat_42'> 63 KM </div>
        <div id='stat_43'> Gorkovskoe </div>
        <div id='stat_44'> Shevelevo </div>
        <div id='stat_45'> Kaneliarvi </div>
        <div id='stat_46'> Zahodskoye </div>
        <div id='stat_47'> Kirillovskoe </div>
        <div id='stat_48'> Leypsya </div>
        <div id='stat_49'> Lebedevka </div>
        <div id='stat_50'> 117 KM </div>
        <div id='stat_51'> Verxne-Cherkasovo </div>
        <div id='stat_52'> Lazoreva </div>
        <div id='stat_53'> Viborg </div>
        <div id='stat_54'> Sadovaya </div>
        <div id='stat_55'> Molodeshnaya </div>
        <div id='stat_56'> Privetenskoe </div>
        <div id='stat_57'> 70 KM </div>
        <div id='stat_58'> 72 KM </div>
        <div id='stat_59'> Masteryarvi </div>
        <div id='stat_60'> Yapilia </div>
        <div id='stat_61'> 86 KM </div>
        <div id='stat_62'> Tarasovskoe </div>
        <div id='stat_63'> Kyolemoyarvi </div>
        <div id='stat_64'> 106 KM </div>
        <div id='stat_65'> Ermilovo </div>
        <div id='stat_66'> Primorsk </div>
        <div id='stat_67'> Bor </div>
    </div>
</div>

<script>

    $("div[id^='stat_']").hover(
        function() {
            $(this).css('background-color', '#6fadd2');
        },
        function() {
            $(this).css('background-color', 'white');
        });

    $("div[id^='stat_']").click(function() {
        if ($('#station1').val()) {
            if ($('#station2').val()) {
                $('#station1').val($(this).text());
                $('#station2').val('');
            } else {
                if ($('#station1').val() != $(this).text()) {
                    $('#station2').val($(this).text());
                    $('#submit').click();
                }
            }
        } else {
            $('#station1').val($(this).text());
        }
    });
</script>

<!-- Add script for bootstrap timepicker -->
<script>
    $('#datetimepicker1').datetimepicker({
    defaultDate: new Date(),
    format: 'YYYY-MM-DD hh:mm:ss',
    sideBySide: true
    });

    $('#datetimepicker2').datetimepicker({
        defaultDate: new Date(),
        format: 'YYYY-MM-DD hh:mm:ss',
        sideBySide: true
    });
</script>
</body>
</html>
