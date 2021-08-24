$('document').ready(function(){
    $('#addmed').on('click', function(){
        if(!$('#med1').is(':visible')){
         $("#med1").show();
         $("#med1 :input").prop('required',true)
         $("#med1 :textarea").prop('required',true)
         $("#med1 :select").prop('required',true)
        }else if(!$('#med2').is(':visible')){
             $("#med2").show();
             $("#med2 :input").prop('required',true)
             $("#med2 :textarea").prop('required',true)
             $("#med2 :select").prop('required',true)
        }else if(!$('#med3').is(':visible')){
            $("#med3").show();
            $("#med3 :input").prop('required',true)
            $("#med3 :textarea").prop('required',true)
            $("#med3 :select").prop('required',true)
        }else{
            $("#med4").show();
            $("#med4 :input").prop('required',true)
            $("#med4 :textarea").prop('required',true)
            $("#med4 :select").prop('required',true)
        }
    })

    $('.btn-close').on('click',function(){
       $("#med1").hide();
        $("#med2").hide();
        $("#med3").hide();
        $("#med4").hide();
    })

})