$.get("xml/VIABoardGames.xml", function(xml, status){
    let txt2 = "";

    $(xml).find("event").each(function()
    {
        var title = $(this).find("title").text();
        var description = $(this).find("description").text();
        var image = $(this).find("imageURL").text();
        var startDate = $(this).find("dates").find("startDate").text();
        var endDate = $(this).find("dates").find("endDate").text();


        txt2 += "<div class='next_container'><div class='next_item'><h3>" + title +"</h3><p>" + description + "</p><p>Start date: " + startDate + "</p><p>End date: " +
         endDate + "</p><img src='./images/" + image + "'></div></div>";
    })

    $("#eventsDisplayed").html(txt2);
});

