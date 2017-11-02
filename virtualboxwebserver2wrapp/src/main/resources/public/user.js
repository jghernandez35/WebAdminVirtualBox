1/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global google */

// Load the Visualization API and the controls package.
//google.load('visualization', '1.0', {'packages': ['controls', 'linechart', 'corechart']});
google.charts.load('current', {'packages': ['table']});

$(document).ready(function () {
    alert("ready");
    //retrieve Service Reference
});

$(function () {
    $("#findall").click(function (event) {
        retrieveUsers();
    });
});

$(function () {
    $("#findone").click(function (event) {
        var idu = $("#id").prop("value");
        retrieveUser(idu);
    });
});

$(function () {
    $("#add").click(function (event) {
        var idu = $("#id").prop("value");
        var identificacionu = $("#identificacion").prop("value");
        var nombresu = $("#nombres").prop("value");
        var apellidosu = $("#apellidos").prop("value");
        var emailu = $("#email").prop("value");
        var celularu = $("#celular").prop("value");
        var telefonou = $("#telefono").prop("value");
        var tipousuariou = $("#tipousuario").prop("value");
        var contrasenau = $("#contrasena").prop("value");
        var jsonUser = '{"id":"' + idu + '","identificacion":"' + identificacionu + '","nombres":"' + nombresu + '","apellidos":"' + apellidosu + '","email":"' + emailu + '","celular":"' + celularu + '","telefono":"' + telefonou + '","tipousuario":"' + tipousuariou + '","contrasena":"' + contrasenau + '"}';
        addUser(jsonUser);
    });
});

function addUser(juser) {
    $.ajax({
        url: 'http://192.168.1.4:8085/user/add',
        type: 'post',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: juser,
        complete: function (rData) {
            //alert("Data: " + rData.toString());
            retrieveUsers();
        }
    });
}

$(function () {
    $("#upd").click(function (event) {
        var idu = $("#id").prop("value");
        var identificacionu = $("#identificacion").prop("value");
        var nombresu = $("#nombres").prop("value");
        var apellidosu = $("#apellidos").prop("value");
        var emailu = $("#email").prop("value");
        var celularu = $("#celular").prop("value");
        var telefonou = $("#telefono").prop("value");
        var tipousuariou = $("#tipousuario").prop("value");
        var contrasenau = $("#contrasena").prop("value");
        var jsonUser = '{"id":"' + idu + '","identificacion":"' + identificacionu + '","nombres":"' + nombresu + '","apellidos":"' + apellidosu + '","email":"' + emailu + '","celular":"' + celularu + '","telefono":"' + telefonou + '","tipousuario":"' + tipousuariou + '","contrasena":"' + contrasenau + '"}';
        updUser(jsonUser);
    });
});

function updUser(jsonuser) {
    $.ajax({
        url: 'http://192.168.1.4:8085/user/upd/',
        type: 'put',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: jsonuser,
        complete: function (rData) {
            //alert("Data: " + rData.toString());
            retrieveUsers();
        }
    });
}

$(function () {
    $("#delete").click(function (event) {
        var idu = $("#id").prop("value");
        delUser(idu);
    });
});

function delUser(id) {
    //delete data
    $.ajax({
        url: 'http://192.168.1.4:8085/user/delete/',
        type: 'delete',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: id,
        complete: function (rData) {
            //alert("Data: " + rData.toString());
            retrieveUsers();
        }
    });
}

function retrieveUsers() {
    //retrieve JSON data
    $.get("http://192.168.1.4:8085/user/findall/", function (rData, status) {
        alert("Data: " + rData.toString() + "\nStatus: " + status);
        drawUsers(rData);
    }, "json");
}

function retrieveUser(idu) {
    //retrieve JSON data
    $.get("http://192.168.1.4:8085/user/find/" + idu + "/", function (rData, status) {
        //alert("Data: " + rData.toString() + "\nStatus: " + status);
        drawUser(rData);
    }, "json");
}

// passes in the data and draws it.
function drawUsers(jsonData) {
    // Create our data table out of JSON data loaded
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Id');
    data.addColumn('string', 'Identificacion');
    data.addColumn('string', 'Nombres');
    data.addColumn('string', 'Apellidos');
    data.addColumn('string', 'Email');
    data.addColumn('string', 'Celular');
    data.addColumn('string', 'Telefono');
    data.addColumn('string', 'TipoUsuario');
    data.addColumn('string', 'Contrasena');
    
    data.addRows(jsonData.length);
    alert("length" + jsonData.length);
    for (var pos = 0; pos < jsonData.length; pos = pos + 1) {
        data.setCell(pos, 0, jsonData[pos].idu);
        data.setCell(pos, 1, jsonData[pos].identificacionu);
        data.setCell(pos, 2, jsonData[pos].nombresu);
        data.setCell(pos, 3, jsonData[pos].apellidosu);
        data.setCell(pos, 4, jsonData[pos].emailu);
        data.setCell(pos, 5, jsonData[pos].celularu);
        data.setCell(pos, 6, jsonData[pos].telefonou);
        data.setCell(pos, 7, jsonData[pos].tipousuariou);
        data.setCell(pos, 8, jsonData[pos].contrasenau);
    }

    // Create a table
    var table = new google.visualization.Table(document.getElementById('table_div'));
    google.visualization.events.addListener(table, 'select', selectHandler);
    table.draw(data, {showRowNumber: false, width: '95%', height: '95%'});

    function selectHandler() {
        var selectedItem = table.getSelection()[0];
        if (selectedItem) {
            $("#id").val(data.getValue(selectedItem.row, 0));
            $("#identificacion").val(data.getValue(selectedItem.row, 1));
            $("#nombres").val(data.getValue(selectedItem.row, 2));
            $("#apellidos").val(data.getValue(selectedItem.row, 3));
            $("#email").val(data.getValue(selectedItem.row, 4));
            $("#celular").val(data.getValue(selectedItem.row, 5));
            $("#telefono").val(data.getValue(selectedItem.row, 6));
            $("#tipousuario").val(data.getValue(selectedItem.row, 7));
            $("#nombres").val(data.getValue(selectedItem.row, 8));
        }
    }
}

function drawUser(jsonData) {
    $("#id").val(jsonData.idu);
    $("#identificacion").val(jsonData.identificacionu);
    $("#nombres").val(jsonData.apellidosu);
    $("#apellidos").val(jsonData.apellidosu);
    $("#email").val(jsonData.emailu);
    $("#celular").val(jsonData.celularu);
    $("#telefono").val(jsonData.telefonou);
    $("#tipousuario").val(jsonData.tipousuariou);
    $("#contrasena").val(jsonData.contrasenau);
    
}