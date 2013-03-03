package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class RoomeventComposer extends GrailsComposer {

    def afterCompose = { window ->
        def  checkusern
        def checkuserid
        def scheckdate
        def scchecklist
        def employeere
        def keepid
        def searchData = DataSignIn.get(2)
        alert(searchData.datainput)
        def employeedata = searchData.datainput
        if(searchData.datainput==null || searchData.datainput==""){
        Executions.sendRedirect("/index.zul")
        }else{
        keepid = searchData.datainput
         employeere = Employee.findByIdem(keepid)
        $('#idrela').setValue(employeere.idem)
        $('#namerela').setValue(employeere.nameem+" "+employeere.lnameem)
        $('#telerela').setValue(employeere.tel)
        $('#strela').setValue(employeere.statusem)
        $('#csrela').setValue(employeere.classem)
        searchData.datainput = ""
        searchData.save()
        }
        String checkDate=""

        
        

     $('#btnsearchid').on('click',{
        def checkid = $('#txtscid').getText()
         checkuserid = MemberCustomer.findByMemberId(checkid)
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

     $('#btnCheck').on('click',{
             scchecklist=$('#listcheckroomre').getSelectedItem().getLabel()
            
            checkDate=$('#datebox').getText()
             scheckdate = MakeEvent.findAllByTypere(scchecklist)
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
            
            $('#btnCar').on('click',{
                 String typeCar = "Carnival"
                String priceCar = "200000"
                def mkevent = new MakeEvent(
                    customer : checkuserid,
                    employee : employeere,
                    typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate
                    )
                mkevent.save()
                alert("save")
                })
            $('#btnSeminar').on('click',{
                  String typeCar = "Seminar"
                String priceCar = "160000"
                def mkevent = new MakeEvent(
                    customer : checkuserid,
                    employee : employeere,
                    typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate
                    )
                mkevent.save()
                  alert("save")
                })
            $('#btnMeet').on('click',{
                  String typeCar = "Meeting"
                String priceCar = "100000"
                def mkevent = new MakeEvent(
                    customer : checkuserid,
                    employee : employeere,
                    typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate
                    )
                mkevent.save()
                  alert("save")
                })
            $('#btnWedding').on('click',{
                  String typeCar = "Wedding"
                String priceCar = "280000"
                def mkevent = new MakeEvent(
                    customer : checkuserid,
                    employee : employeere,
                    typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate
                    )
                mkevent.save()
                  alert("save")
                })
    }
}
