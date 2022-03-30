$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/rest-jersey/webapi/movies/movie/10"
    }).then(function(data) {
       $('.movie-name').append(data.name);
       $('.movie-rating').append(data.rating);
    });
});