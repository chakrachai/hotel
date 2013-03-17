package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class EventcustomerComposer extends GrailsComposer {

    def afterCompose = { window ->
        def checkuserc
        def checkuseridc
        def scheckdatec
        def scchecklistc
        def keepidc
        def keepidc2 = DataSignIn.findById("5")
        def searchDatac = DataSignIn.get(2)
        def checksendc
        def checkDatec

        if(searchDatac.datainput==null  || searchDatac.datainput==""){
            if(keepidc2.datainput==null || keepidc2.datainput==""){
                alert(keepidc2.datainput)
                Executions.sendRedirect("/index.zul")
            }else{
                keepidc=keepidc2.datainput
                checkuseridc = MemberCustomer.findByMemberId(keepidc)
                    $('#idcusc').setValue(checkuseridc.memberId)
                     $('#namec').setValue(checkuseridc.fName)
                    $('#lnamec').setValue(checkuseridc.lName)
                    $('#mnamec').setValue(checkuseridc.mName)
                  $('#telc').setValue(checkuseridc.age)
                 $('#addc').setValue(checkuseridc.address)
                 $('#countryc').setValue(checkuseridc.nationality)
                 $('#emailc').setValue(checkuseridc.emailAddress)
            
                  searchDatac.datainput = ""
                  searchDatac.save()
            }
        }else{
            keepidc = searchDatac.datainput
            keepidc2.datainput = keepidc
            keepidc2.save()
            checkuseridc = MemberCustomer.findByMemberId(keepidc)
                    $('#idcusc').setValue(checkuseridc.memberId)
                     $('#namec').setValue(checkuseridc.fName)
                    $('#lnamec').setValue(checkuseridc.lName)
                    $('#mnamec').setValue(checkuseridc.mName)
                  $('#telc').setValue(checkuseridc.age)
                 $('#addc').setValue(checkuseridc.address)
                 $('#countryc').setValue(checkuseridc.nationality)
                 $('#emailc').setValue(checkuseridc.emailAddress)
              
                  searchDatac.datainput = ""
                  searchDatac.save()

        }
        







          $('#logoutrec').on('click',{
        keepidc2.datainput=""
        keepidc2.save()
        Executions.sendRedirect("/index.zul")
        })  

             $('#btnCheckc').on('click',{
                 scchecklistc=$('#listcheckroomrec').getSelectedItem().getLabel()
             alert(scchecklistc)
            checkDatec=$('#dateboxc').getText()
             scheckdatec=MakeEvent.findAllByTypere(scchecklistc)
            def rubkarc
            for(checkloop in scheckdatec){
                //alert(""+checkloop.datere)
                if(checkDatec==checkloop.datere){
                rubkarc=checkloop.datere
            }

            }
                if(checkDatec==rubkarc){
                    if(scchecklistc == "Carnival"){
                    $('#CrSc').setLabel("Off")
                
                    }
                    else if(scchecklistc == "Meeting"){
                    $('#MrSc').setLabel("Off")
                    }
                    else if(scchecklistc == "Wedding"){
                    $('#WrSc').setLabel("Off")
                    }
                    else if(scchecklistc == "Seminar"){
                    $('#SrSc').setLabel("Off")
                    }
                }else{
                    if(scchecklistc == "Carnival"){
                    $('#CrSc').setLabel("On")
                    $('#SrSc').setLabel("Off")
                    $('#WrSc').setLabel("Off")
                    $('#MrSc').setLabel("Off")
                    }
                    else if(scchecklistc == "Meeting"){
                    $('#MrSc').setLabel("On")
                     $('#CrSc').setLabel("Off")
                    $('#SrSc').setLabel("Off")
                    $('#WrSc').setLabel("Off")
                    }
                    else if(scchecklistc == "Wedding"){
                    $('#WrSc').setLabel("On")
                    $('#MrSc').setLabel("Off")
                     $('#CrSc').setLabel("Off")
                    $('#SrSc').setLabel("Off")
                    }
                    else if(scchecklistc == "Seminar"){
                    $('#SrSc').setLabel("On")
                    $('#WrSc').setLabel("Off")
                    $('#MrSc').setLabel("Off")
                     $('#CrSc').setLabel("Off")
                    }
                }

                if($('#CrSc').getLabel()=="Off"){
                    $('#btnCarc').setVisible(false)
                }else{
                    $('#btnCarc').setVisible(true)
                }
                if($('#SrSc').getLabel()=="Off"){
                    $('#btnSeminarc').setVisible(false)
                }else{
                     $('#btnSeminarc').setVisible(true)
                }
                if($('#MrSc').getLabel()=="Off"){
                    $('#btnMeetc').setVisible(false)
                }else{
                    $('#btnMeetc').setVisible(true)
                }
                if($('#WrSc').getLabel()=="Off"){
                    $('#btnWeddingc').setVisible(false)
                }else{
                     $('#btnWeddingc').setVisible(true)
                }



            }) 

            $('#btnSendc').on('click',{
                checksendc = $('#dateboxsendc').getText()
                alert(checksendc)
                })
            
                   $('#btnCarc').on('click',{
                 String typeCarc = "Carnival"
                String priceCarc = "200000"
                def mkeventc = new MakeEventCustomer(
                    customerc : checkuseridc,
                    typerec : typeCarc,
                    pricerec : priceCarc,
                    daterec : checkDatec,
                    dateresendc : checksendc
                    )
                mkeventc.save()
                alert("save")
                 alert("พิมพ์หน้านี้ เพื่อนำไปยืนยัน")
                })
            $('#btnSeminarc').on('click',{
                  String typeCarc = "Seminar"
                String priceCarc = "160000"
                def mkeventc = new MakeEventCustomer(
                    customerc : checkuseridc,
                    typerec : typeCarc,
                    pricerec : priceCarc,
                    daterec : checkDatec,
                    dateresendc : checksendc
                    )
                mkeventc.save()
                  alert("save")
                   alert("พิมพ์หน้านี้ เพื่อนำไปยืนยัน")
                })
            $('#btnMeetc').on('click',{
                  String typeCarc = "Meeting"
                String priceCarc = "100000"
                def mkeventc = new MakeEventCustomer(
                    customerc : checkuseridc,
                    typerec : typeCarc,
                    pricerec : priceCarc,
                    daterec : checkDatec,
                    dateresendc : checksendc
                    )
                mkeventc.save()
                  alert("save")
                   alert("พิมพ์หน้านี้ เพื่อนำไปยืนยัน")
                })
            $('#btnWeddingc').on('click',{
                  String typeCarc = "Wedding"
                String priceCarc = "280000"
                def mkeventc = new MakeEventCustomer(
                    customerc : checkuseridc,
                    typerec : typeCarc,
                    pricerec : priceCarc,
                    daterec : checkDatec,
                    dateresendc : checksendc
                    )
                mkeventc.save()
                  alert("save")
                  alert("พิมพ์หน้านี้ เพื่อนำไปยืนยัน")
                })
    }
}




