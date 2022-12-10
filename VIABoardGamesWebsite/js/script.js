$.get("xml/VIABoardGames.xml", function(xml, status){
    let txt = "";


    $(xml).find("game").each(function()
    {
        var title = $(this).find("title").text();
        var owner = $(this).find("owner").text();
        var maxNr = $(this).find("maxNumberOfPlayers").text();
        var rating = $(this).find("rating").text();
        
        txt += "<div class='game_info'><img src='./images/catana_game.jpg'><p>Game: "+ title + "</p><p>Owner: "+ owner + "</p><p>Players:" + maxNr + "</p><p>Rating:"+
        + rating +"</p></div>";
    })

    $("#catalog").html(txt);
});
