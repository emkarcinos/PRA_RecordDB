var outputId = "output";

var artistBtn = document.querySelector('.button1');

function createLabelsTable(labelsData) {
    var tbltop = `<table cellspacing="10"><tr><th>Id</th><th>Name</th><th>Webpage</th></tr>`;
            var main = "";
            for (i = 0; i < labelsData.length; i++) {
                main += "<tr><td>"+labelsData[i].id+"</td><td>"+labelsData[i].name+"</td><td><a href="+labelsData[i].webpage+">"+labelsData[i].webpage+"</a></td></tr>";
            }
            var tblbottom = "</table>";
            var tbl = tbltop + main + tblbottom;
      
            document.getElementById(outputId).innerHTML = tbl;
}
function createArtistsTable(artistsData) {
    var tbltop = `<table cellspacing="10"><tr><th>Id</th><th>Name</th></tr>`;
            var main = "";
            for (i = 0; i < artistsData.length; i++) {
                main += "<tr><td id=\"artist"+artistsData[i].id+"\">"+artistsData[i].id+"</td><td>"+artistsData[i].name+"</td></tr>";
            }
            var tblbottom = "</table>";
            var tbl = tbltop + main + tblbottom;
            document.getElementById(outputId).innerHTML = tbl;
            
            var artist1btn = document.querySelector('.artist1');

            artist1btn.addEventListener('click', function(){
                document.getElementById(outputId).innerHTML = "1242"
            });
}


function createAlbumsTable(albumsData) {
    var tbltop = `<table cellspacing="10"><tr><th>Id</th><th>Name</th><th>Year</th><th>Artist</th></tr>`;
            var main = "";
            for (i = 0; i < albumsData.length; i++) {
                main += "<tr><td>"+albumsData[i].id+"</td><td>"+albumsData[i].name+"</td><td>"+albumsData[i].year+"</td><td>"+albumsData[i].artist.name+"</td></tr>";
            }
            var tblbottom = "</table>";
            var tbl = tbltop + main + tblbottom;
            document.getElementById(outputId).innerHTML = tbl;
}

function query(type, url){
    var request = new XMLHttpRequest();
    request.open(type, url, true);
    var responseData;
    document.getElementById(outputId).innerHTML = "Loading data...";
    request.onreadystatechange = function() {
        if(request.readyState === 4 && request.status === 200) {
            responseData = JSON.parse(this.responseText);
            if(url === '/api/artists')
                createArtistsTable(responseData);
            else if(url === '/api/albums')
                createAlbumsTable(responseData);
            else if(url === '/api/labels')
                createLabelsTable(responseData);
        }
    };
    request.send();
}

artistBtn.addEventListener('click', function(){
    query('GET', '/api/artists');
});

var albumsBtn = document.querySelector('.button2');

albumsBtn.addEventListener('click', function(){
    query('GET', '/api/albums');
})

var labelsBtn = document.querySelector('.button3');

labelsBtn.addEventListener('click', function(){
    query('GET', '/api/labels');
});