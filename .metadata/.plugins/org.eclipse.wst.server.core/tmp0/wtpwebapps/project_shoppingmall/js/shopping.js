$(document).ready(function(){

  $('.shop_select>.shop_select_all_bt').click(function (e) {
    $(this).toggleClass('On');
    $('.shop_product_detail>.shop_select_all_bt').toggleClass('On');
  });


});