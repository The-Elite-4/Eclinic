$('document').ready(function(){
    $('#addmed').on('click', function(){
        if(!$('#med2').is(':visible')){
             $("#med2").show();
        }else if(!$('#med3').is(':visible')){
            $("#med3").show();
        }else{
            $("#med4").show();
        }
    })

    $('.btn-close').on('click',function(){
        $("#med2").hide();
        $("#med3").hide();
        $("#med4").hide();
    })
})