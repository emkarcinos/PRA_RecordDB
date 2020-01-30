var outputId = "output";

var artistBtn = document.querySelector('.button1');

function queryArtists(){
    var request = new XMLHttpRequest();
    request.open('GET', '/api/artists', true);
    request.onreadystatechange = function() {
        if(request.readyState === 4 && request.status === 200) {
            var artists = JSON.parse(this.responseText);
            var tbltop = `<table><tr><th>Id</th><th>Name</th></tr>`;
            var main = "";
            for (i = 0; i < artists.length; i++) {
                main += "<tr><td>"+artists[i].id+"</td><td>"+artists[i].name+"</td></tr>";
            }
            var tblbottom = "</table>";
            var tbl = tbltop + main + tblbottom;
            console.log(tbl);
            document.getElementById(outputId).innerHTML = tbl;
        }
    };
    request.send();
}

artistBtn.addEventListener('click', function(){
    queryArtists();
});

var albumsBtn = document.querySelector('.button2');

albumsBtn.addEventListener('click', function(){
    var output = document.getElementById(outputId);
    output.innerHTML = "<p>ASDSA<\p>"
})