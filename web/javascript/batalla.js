/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




//Metodo que mepermite adicionar X barcos en X posiciones

function tenerCoordeanadas() {

    var guardarDatosDeCoordenadas = new Array(100);
    var tablaDiez = document.getElementById('miTablaPosicion');
    var coords = document.getElementById('coordsInput').value;
    var retiroDeSignos1 = coords.replace('[', '');
    var retiroDeSignos2 = retiroDeSignos1.replace(']', '');
    var asignarCoodenada;
    guardarDatosDeCoordenadas = retiroDeSignos2.split(',');
    for (var i = 0; i < guardarDatosDeCoordenadas.length; ) {
        asignarCoodenada = guardarDatosDeCoordenadas[i].split('.');
        var x = parseInt(asignarCoodenada[0]) - 1;
        var y = parseInt(asignarCoodenada[1]) - 1;
        tablaDiez.getElementsByTagName('tr')[y].getElementsByTagName('td')[x].innerHTML = 'PUSH';
        i++;
        buscarDatos();
    }
}

window.onload = function lanzadera() {
    tenerCoordeanadas();
}

//window.onload = lanzadera;






//Metodo que me permite el cambio de color en las coordenadas con AGUA
function buscarDatos() {
    var datos = document.getElementsByTagName('td');
    for (var i = 0; i < datos.length; i++) {
        if (datos[i].innerHTML === 'PUSH') {
            datos[i].style.backgroundColor = "red";
        }
    }
}

//Metodo que mepermite adicionar disparos
function adicionarDisparos() {
    var tablaDisparosJugadorDos = document.getElementById('miTablaJugadorDos');
    var tablaDisparosJugadorUno = document.getElementById('miTablaDisparos');
    var datos = document.getElementById('coordsDis').value.split(',');
    var x = parseInt(datos[0]) - 1;
    var y = parseInt(datos[1]) - 1;
    tablaDisparosJugadorUno.getElementsByTagName('tr')[y].getElementsByTagName('td')[x].innerHTML = 'PUSH';
    tablaDisparosJugadorDos.getElementsByTagName('tr')[y].getElementsByTagName('td')[x].innerHTML = 'PUSH';
    tablaDisparosJugadorDos.getElementsByTagName('tr')[y].getElementsByTagName('td')[x].style.backgroundColor = "green";
    buscarDisparos();
}

//Inicio de adicionar disparo en otro tablero



//Metodo que me permite el cambio de color los disparos con AGUA
function buscarDisparos() {
//    alert("hola");
    var datosTablaDisparo = document.getElementById('miTablaDisparos');
//    var x = datosTablaDisparo.getElementsByTagName('tr')[1].getElementsByTagName('td')[1].innerHTML;
//    alert(x);
//    alert("SOn estos: " + datosTablaDisparo.getElementsByTagName('td').length);
    for (var i = 1; i < datosTablaDisparo.getElementsByTagName('td').length; i++) {
//        var x = datosTablaDisparo.getElementsByTagName('td')[i].innerHTML;
        if (datosTablaDisparo.getElementsByTagName('td')[i].innerHTML === 'PUSH') {
            datosTablaDisparo.getElementsByTagName('td')[i].style.backgroundColor = "yellow";
        }
    }
}