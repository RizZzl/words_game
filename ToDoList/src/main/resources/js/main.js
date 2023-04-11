$(function(){

    const appendToDo = function(data){
        var toDoCode = '<a href="#" class="toDo-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#toDo-list')
            .append('<div>' + toDoCode + '</div>');
    };

    //Show adding toDoList form
    $('#show-add-toDo-form').click(function(){
        $('#toDo-form').css('display', 'flex');
    });

    //Closing adding toDoList form
    $('#toDo-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting toDoList
    $(document).on('click', '.ToDo-link', function(){
        var link = $(this);
        var toDoId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/toDoList/' + toDoId,
            success: function(response)
            {
                var code = '<span>Год выпуска:' + response.year + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Дело не найдена!');
                }
            }
        });
        return false;
    });

    //Adding toDoList
    $('#save-toDo').click(function()
    {
        var data = $('#toDo-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/toDoList/',
            data: data,
            success: function(response)
            {
                $('#toDo-form').css('display', 'none');
                var toDo = {};
                toDo.id = response;
                var dataArray = $('#toDo-form form').serializeArray();
                for(i in dataArray) {
                    toDo[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendToDo(toDo);
            }
        });
        return false;
    });

});