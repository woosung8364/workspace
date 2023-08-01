$(document).ready(function(){

   $('.recom_tab .btn_tab').click(function (e) {
     e.preventDefault();
     $('.recom_tab .btn_tab').removeClass('Act');
     $(this).addClass('Act');

     var idx = $('.recom_tab .btn_tab.Act').index();
     $('.recom_list_wrap>ul').removeClass('On');
     $('.recom_list_wrap>ul').eq(idx).addClass('On');
   });



  // with

  $('.with_list').slick({
        dots: false,
        infinite: false,
        arrows:true,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [
          {
            breakpoint: 1190,
            settings: {
              slidesToShow: 3,
              slidesToScroll: 3,
            }
          },
          {
            breakpoint: 767,
            settings: {
              slidesToShow: 2,
              slidesToScroll: 2
            }
          },
          {
            breakpoint: 480,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1
            }
          }
        ]
      });



   // flagship







});
