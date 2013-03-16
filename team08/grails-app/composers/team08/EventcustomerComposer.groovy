package team08

import org.zkoss.zk.grails.composer.*
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class EventcustomerComposer extends GrailsComposer {

    def afterCompose = { window ->
        def checkusern
        def checkuserid
        def scheckdate
        def scchecklist
        def keepid
        def keepid2 = DataSignIn.findById("3")

        def searchData = DataSignIn.get(2)







          $('#logoutre').on('click',{
        keepid2.datainput=""
        keepid2.save()
        Executions.sendRedirect("/index.zul")
        })  

             $('#btnCheck').on('click',{
             scchecklist=$('#listcheckroomre').getSelectedItem().getLabel()
            
            checkDate=$('#datebox').getText()
             scheckdate = MakeEventCustomer.findAllByTypere(scchecklist)
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
                    $('#SrS').setLabel("Off")
                    $('#WrS').setLabel("Off")
                    $('#MrS').setLabel("Off")
                    }
                    else if(scchecklist == "Meeting"){
                    $('#MrS').setLabel("On")
                     $('#CrS').setLabel("Off")
                    $('#SrS').setLabel("Off")
                    $('#WrS').setLabel("Off")
                    }
                    else if(scchecklist == "Wedding"){
                    $('#WrS').setLabel("On")
                    $('#MrS').setLabel("Off")
                     $('#CrS').setLabel("Off")
                    $('#SrS').setLabel("Off")
                    }
                    else if(scchecklist == "Seminar"){
                    $('#SrS').setLabel("On")
                    $('#WrS').setLabel("Off")
                    $('#MrS').setLabel("Off")
                     $('#CrS').setLabel("Off")
                    }
                }

                if($('#CrS').getLabel()=="Off"){
                    $('#btnCar').setVisible(false)
                }else{
                    $('#btnCar').setVisible(true)
                }
                if($('#SrS').getLabel()=="Off"){
                    $('#btnSeminar').setVisible(false)
                }else{
                     $('#btnSeminar').setVisible(true)
                }
                if($('#MrS').getLabel()=="Off"){
                    $('#btnMeet').setVisible(false)
                }else{
                    $('#btnMeet').setVisible(true)
                }
                if($('#WrS').getLabel()=="Off"){
                    $('#btnWedding').setVisible(false)
                }else{
                     $('#btnWedding').setVisible(true)
                }



            }) 

			$('#btnSend').on('click',{
				checksend = $('#dateboxsend').getText()
				})
			
			       $('#btnCar').on('click',{
                 String typeCar = "Carnival"
                String priceCar = "200000"
                def mkevent = new MakeEventCustomer(
                    customer : checkuserid,
  					typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate,
                    dateresend : checksend
                    )
                mkevent.save()
                alert("save")
                })
            $('#btnSeminar').on('click',{
                  String typeCar = "Seminar"
                String priceCar = "160000"
                def mkevent = new MakeEventCustomer(
                    customer : checkuserid,
  					typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate,
                    dateresend : checksend
                    )
                mkevent.save()
                  alert("save")
                })
            $('#btnMeet').on('click',{
                  String typeCar = "Meeting"
                String priceCar = "100000"
                def mkevent = new MakeEventCustomer(
                    customer : checkuserid,
  					typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate,
                    dateresend : checksend
                    )
                mkevent.save()
                  alert("save")
                })
            $('#btnWedding').on('click',{
                  String typeCar = "Wedding"
                String priceCar = "280000"
                def mkevent = new MakeEventCustomer(
                    customer : checkuserid,
  					typere : typeCar,
                    pricere : priceCar,
                    datere : checkDate,
                    dateresend : checksend
                    )
                mkevent.save()
                  alert("save")
                })
    }
}




