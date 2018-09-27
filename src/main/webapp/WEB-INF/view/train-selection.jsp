<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select station</title>
    <style>

        h1 {
            display: block;
            font-size: 2em;
            margin-top: 0.67em;
            margin-bottom: 0.67em;
            margin-left: 0;
            margin-right: 0;
            font-weight: bold;
            color: #5B90B0
        }

        input[type=text] {
            width: 250px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;
            background-image: url('searchicon.png');
            background-position: 10px 10px;
            background-repeat: no-repeat;
            padding: 12px 20px 12px 40px;
            -webkit-transition: width 0.4s ease-in-out;
            transition: width 0.4s ease-in-out;
        }

        input[type=text]:focus {
            width: 100%;
        }


        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div focus {
            width: 100%;
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>

        <h1>🚉 Select station:</h1>
        <br><br>

        <div>
            <center>
            <form:form method="POST" action="selectTrainsByStation"  modelAttribute="selectedStation">

                <form:input type="text" name="search" path="name" placeholder="Station name"  autocomplete='off' list='stations_list'/>

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

                    <br><br>
                    <center><button class="button" type="submit">Select</button></center>
            </form:form>
            </center>
        </div>

</body>
</html>
