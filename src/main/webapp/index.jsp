<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movies</title>

    <!-- INCLUDING JQUERY-->
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
    </script>

    <!-- CSS FOR STYLING THE PAGE -->
    <style>
        table {
            background: #9c9c9c;
            margin: 0 auto;
            font-size: large;
            border: 5px solid black;
        }

        h1 {
            text-align: center;
            color: #000000;
            font-size: xx-large;
            font-family: 'Gill Sans',
                'Gill Sans MT', ' Calibri',
                'Trebuchet MS', 'sans-serif';
        }

        td {
            background-color: #c7c7c7;
            border: 1px solid black;
        }

        th,
        td {
            font-weight: bold;
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }

        td {
            font-weight: lighter;
        }
    </style>
</head>

<body>
    <section>
        <h1>Movies with Movies</h1>

        <table id='table'>
            <tr>
                <th>Poster</th>
                <th>ID</th>
                <th>Movie Name</th>
                <th>Rating</th>
            </tr>

            <script>
                $(document).ready(function () {
                    $.getJSON("http://localhost:8080/rest-jersey/webapi/movies", function (data) {
                    var movie = '';
                        $.each(data, function (key, value) {
                            movie += '<tr>';
                            movie += '<td> <img src='+ value.poster +'></td>';
                            movie += '<td>' + value.id + '</td>';
                            movie += '<td>'+ value.name + '</td>';
                            movie += '<td>' + value.rating + '</td>';
                            movie += '</tr>';
                        });
                        $('#table').append(movie);
                    });
                });
            </script>
    </section>
</body>
</html>