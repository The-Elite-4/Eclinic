$('document').ready(function(){
    $('#addmed').on('click', function(){
        if(!$('#med1').is(':visible')){
         $("#med1").show();
        }else if(!$('#med2').is(':visible')){
             $("#med2").show();
        }else if(!$('#med3').is(':visible')){
            $("#med3").show();
        }else{
            $("#med4").show();
        }
    })

    $('.btn-close').on('click',function(){
       $("#med1").hide();
        $("#med2").hide();
        $("#med3").hide();
        $("#med4").hide();
    })

    $('#multipleFormSubmit').on('click',function(){
        $('#mainForm').submit();
        $('#med1').submit(function(e){
                              e.preventDefault();
                            });
        $('#med2').submit(function(e){
                              e.preventDefault();
                            });
        $('#med3').submit(function(e){
                              e.preventDefault();
                            });
        $('#med4').submit(function(e){
                              e.preventDefault();
                            });
    })
})