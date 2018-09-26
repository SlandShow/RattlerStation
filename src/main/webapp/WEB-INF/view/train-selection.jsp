<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select station</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1 class="text-info">Select station:</h1>
        <br><br>


<form:form method="POST" action="selectTrainsByStation"  modelAttribute="selectedStation">

<div class="row">
                <div class="form-group ">

    <form:input class="form-control" type="text" path="name" placeholder="Station name"  autocomplete='off' list='stations_list'/>

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
                </div>
            </div>

<center>
            <div class="row">
                <button type="submit" class="btn btn-default">Submit</button>
            </div></center>
        </form:form>



    </div>
</body>
</html>
