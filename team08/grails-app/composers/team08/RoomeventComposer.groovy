package team08

import org.zkoss.zk.grails.composer.*

import org.zkoss.zk.ui.select.annotation.Wire
import org.zkoss.zk.ui.select.annotation.Listen

class RoomeventComposer extends GrailsComposer {

    def afterCompose = { window ->
        String checkDate=""
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

            })
    }
}
