var input = prompt("Enter value", 0);

console.log("input value = " + input);

var result = input * 3.14;
alert("Результат вычисления: " + result)

var testFunc = function (text) {
    console.log(text);
}

var humanInput = prompt("Введите что-нибудь", "Ничего не введено");

$(document).ready(function(){
    // Get value on button click and show alert
    $("#myBtn").click(function(){
        var str = $("#myInput").val();
        alert(str);
    });
});

testFunc(humanInput);

testFunc(alertFunction);


