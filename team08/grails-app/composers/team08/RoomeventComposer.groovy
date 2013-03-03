package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class RoomeventComposer extends GrailsComposer {

    def afterCompose = { window ->
        String checkDate=""

     $('#btnsearchid').on('click',{
        def checkid = $('#txtscid').getText()
        def checkuserid = MemberCustomer.findByMemberId(checkid)
        if(checkid.size() == 0){
            alert("พิมพ์ด้วยคราบ")
         }else{
            if(checkuserid == null){
            
            alert("ไม่เห็นเว้ยเห้ย")
          
        }else{
          
         
         // alert(checkuserid.memberId)
           $('#idcus').setValue(checkuserid.memberId)
           $('#name').setValue(checkuserid.fName)
           $('#lname').setValue(checkuserid.lName)
            $('#mname').setValue(checkuserid.mName)
            $('#tel').setValue(checkuserid.age)
            $('#add').setValue(checkuserid.address)
            $('#country').setValue(checkuserid.nationality)
            $('#email').setValue(checkuserid.emailAddress)
             }
            }
        
     })   
     $('#btnsearchn').on('click',{
        def checkn = $('#txtscname').getText()
        def  checkusern = MemberCustomer.findByFName(checkn)
       if(checkn.size() == 0){
            alert("พิมพ์ด้วยคราบ")
         }else{
            if(checkusern == null){
            
            alert("ไม่เจออ๊ะ")
          
        }else{
        $('#idcus').setValue(checkusern.memberId)
        $('#name').setValue(checkusern.fName)
        $('#lname').setValue(checkusern.lName)
        $('#mname').setValue(checkusern.mName)
        $('#tel').setValue(checkusern.age)
        $('#add').setValue(checkusern.address)
        $('#country').setValue(checkusern.nationality)
        $('#email').setValue(checkusern.emailAddress)
         }
            }  
        })

     $('#btnCheck').on('click',{
            def scchecklist=$('#listcheckroomre').getSelectedItem().getLabel()
            
            checkDate=$('#datebox').getText()
            def scheckdate = MakeEvent.findAllByTypere(scchecklist)
            def rubkar
            for(checkloop in scheckdate){
                //alert(""+checkloop.datere)
                if(checkDate==checkloop.datere){
                rubkar=checkloop.datere
            }

            }
                if(checkDate==rubkar){
                    if(scchecklist == "Carnival"){
                    $('#CrS').setLabel("Off")
                
                    }
                    else if(scchecklist == "Meeting"){
                    $('#MrS').setLabel("Off")
                    }
                    else if(scchecklist == "Wedding"){
                    $('#WrS').setLabel("Off")
                    }
                    else if(scchecklist == "Seminar"){
                    $('#SrS').setLabel("Off")
                    }
                }else{
                    if(scchecklist == "Carnival"){
                    $('#CrS').setLabel("On")
                    }
                    else if(scchecklist == "Meeting"){
                    $('#MrS').setLabel("On")
                    }
                    else if(scchecklist == "Wedding"){
                    $('#WrS').setLabel("On")
                    }
                    else if(scchecklist == "Seminar"){
                    $('#SrS').setLabel("On")
                    }
                }

                if($('#CrS').getLabel()=="Off"){
                    $('#btnCar').setVisible(false)
                }
                else if($('#SrS').getLabel()=="Off"){
                    $('#btnSeminar').setVisible(false)
                }
                else if($('#MrS').getLabel()=="Off"){
                    $('#btnMeet').setVisible(false)
                }
                else if($('#WrS').getLabel()=="Off"){
                    $('#btnWedding').setVisible(false)
                }
                else if($('#CrS').getLabel()=="On"){
                    $('#btnCar').setVisible(true)
                }
                else if($('#SrS').getLabel()=="On"){
                    $('#btnSeminar').setVisible(true)
                }
                else if($('#MrS').getLabel()=="On"){
                    $('#btnMeet').setVisible(true)
                }
                else if($('#WrS').getLabel()=="On"){
                    $('#btnWedding').setVisible(true)
                }



            })
    }
}
