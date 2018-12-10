$(function() {

    var product = $("div.prodType");
    product.next().addClass("hidden");
    product.on("click",function () {
        $(this).find('tr').toggleClass("rolldown");
        $(this).next().toggleClass("hidden");
    })

})