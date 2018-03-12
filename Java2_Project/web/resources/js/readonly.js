/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 var list=document.getElementsByClassName("readTxt");
 for (var index = 0; index < list.length; ++index) 
 {
     list[index].setAttribute("readonly","true");
 }