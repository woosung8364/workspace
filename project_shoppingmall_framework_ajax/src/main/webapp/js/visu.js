$(document).ready(function(){

  // 1.첫번째 슬라이드 나오게 하기
  // 2.첫번째 슬라이드가 나오는 함수 만들기
  // 3.함수 실행하기
  first_act();
  function first_act() {

   $('.visu_slide').eq(0).addClass('Active');
   $('.visu_btm_wrap>li').eq(0).addClass('Act')

    active();
 }

//4. slide에 class가 붙고 난후 벌어지는 일련의 행동들모음을 함수로 만듬

  function active() {

  $('.visu_slide.Active').children('.visu_veil').animate({'width':'44%'},1000);
  $('.visu_slide.Active').children('.visu_txt_wrap').delay(1500).animate({'opacity':'1'},1000);

  }
// 5 reset(초기화)함수 만들기

  function reset() {

  $('.visu_slide').removeClass('Active');
  $('.visu_btm_wrap>li').removeClass('Act')
  $('.visu_slide').children('.visu_veil').animate({'width':'0%'},0);
  $('.visu_slide').children('.visu_txt_wrap').animate({'opacity':'0'},0);
}


  // 6.right click
    $('.visu_arrow.right').click(function () {

        // active가 된 현재의 순서값 변수로 저장
         var idx = $('.visu_slide.Active').index();

         reset();
        if(idx<2){//idx가 2보다 작을때는 idx값에 + 1을 한다

             $('.visu_slide').eq(idx+1).addClass('Active');
             $('.visu_btm_wrap>li').eq(idx+1).addClass('Act')

        }
        else if(idx==2){//idx가 2와 같아지면 idx=0
          $('.visu_slide').eq(0).addClass('Active');
          $('.visu_btm_wrap>li').eq(0).addClass('Act')

        }


      active()
    });
  // 7.left click
    $('.visu_arrow.left').click(function () {

          // active가 된 현재의 순서값 변수로 저장
           var idx = $('.visu_slide.Active').index();

           reset();
          if(idx>0){//idx가 0보다 클때 idx값에 - 1을 한다

               $('.visu_slide').eq(idx-1).addClass('Active');
               $('.visu_btm_wrap>li').eq(idx-1).addClass('Act')

          }
          else if(idx==0){//idx가 0와 같아지면 idx=2
            $('.visu_slide').eq(2).addClass('Active');
            $('.visu_btm_wrap>li').eq(2).addClass('Act')

          }


        active()
      });
  // 8.btm btn click
  $('.visu_btm_wrap li').not('.controls_wrap').click(function(e) {
    e.preventDefault();

       reset();//초기화
        var idx= $(this).index();//현재순서값 저장
        $(this).addClass('Act');//나 자신 하단버튼 클래스 붙이기
        // 슬라이드 순서값에 맞늕 클래스 붙이기
        $('.visu_slide').eq(idx).addClass('Active');
        // active함수
       active();


  })

  // 9.슬라이드가 계속 실행되게 함
    //9-1 오른쪽 버튼 클릭하는 내용을 함수로 만들기
    function play() {
      $('.visu_arrow.right').click();
    }
   //9-2 계속 실행되게 함을 변수로 대입한다
   var slider_play = setInterval(play,8000);

   // 9-3 멈추는 변수 정의
   var slider_stop;


   // 10.stop btn을 클릭했을때

   $('.controls_wrap .control.stop').click(function (e) {
     e.preventDefault();

     $(this).fadeOut(0);
     $('.controls_wrap .control.start').fadeIn(0);
     slider_stop=clearInterval(slider_play);
   })

   $('.controls_wrap .control.start').click(function (e) {
     e.preventDefault();
     $(this).fadeOut(0);
      $('.controls_wrap .control.stop').fadeIn(0);

     slider_play=setInterval(play,8000);
   })

   setInterval(function(){
     $('.flag_side.f_right').click();
   },5000);

   $('.flag_side.f_right').click(function(){
     var idx=$('.flag_slider li.On').index();

     $('.flag_btm_wrap li').removeClass('Act');
     $('.flag_slider li').removeClass('On');


     if(idx < 2){
       $('.flag_btm_wrap li').eq(idx+1).addClass('Act');
       $('.flag_slider li').eq(idx+1).addClass('On');
     }

     else if(idx == 2){
         $('.flag_btm_wrap li').eq(0).addClass('Act');
         $('.flag_slider li').eq(0).addClass('On');
     }

   })

   $('.flag_side.f_left').click(function(){
     var idx=$('.flag_slider li.On').index();

     $('.flag_btm_wrap li').removeClass('Act');
     $('.flag_slider li').removeClass('On');


     if(idx > 0){
       $('.flag_btm_wrap li').eq(idx-1).addClass('Act');
       $('.flag_slider li').eq(idx-1).addClass('On');
     }

     else if(idx == 0){
         $('.flag_btm_wrap li').eq(2).addClass('Act');
         $('.flag_slider li').eq(2).addClass('On');
     }

   })


   $('.flag_btm_wrap li').click(function(e){
     e.preventDefault();
     var idx=$(this).index();
      $('.flag_slider li').removeClass('On');
      $('.flag_slider li').eq(idx).addClass('On');
      $('.flag_btm_wrap li').removeClass('Act');
      $('.flag_btm_wrap li').eq(idx).addClass('Act');

   })

   window.addEventListener('scroll', function() {
    var header = document.querySelector('header');
    var scrollPosition = window.scrollY;
  
    if (scrollPosition > 0) {
      header.classList.add('scrolled');
    } else {
      header.classList.remove('scrolled');
    }
  });
});
